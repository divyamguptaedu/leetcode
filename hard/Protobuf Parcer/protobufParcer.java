/*
implement protobuf parser with the following functionalities:

'''
Message xxx
int field1
int field2
string field3
float field4

Message yyy
string field1
float field2
'''

parser.get_size('yyy') # 260
parser.get_size('int') # 4
parser.get_type('xxx', 'field1') # int 

Note:
int size: 4, 
float size: 4, 
string size: 256
*/

class ProtobufParser {
    HashMap<String, HashMap<String, String>> messages;
    HashMap<String, Integer> typeSizes;

    public ProtobufParser() {
        messages = new HashMap<>();
        typeSizes = new HashMap<>();
        typeSizes.put("int", 4);
        typeSizes.put("float", 4);
        typeSizes.put("string", 256);
    }

    public void parseInput(String input) {
        String[] lines = input.split("\n");
        String messageName = null;
        HashMap<String, String> fields = null;

        for (String line : lines) {
            line = line.trim(); // Remove leading and trailing whitespaces
            if (line.startsWith("Message")) { // Extract message name
                messageName = line.split(" ")[1];
                fields = new HashMap<>();
                messages.put(messageName, fields);
            } else if (!line.isEmpty()) { // Extract message fields
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    fields.put(parts[1], parts[0]);
                }
            }
        }
    }

    public String getType(String messageName, String fieldName) {
        if (messages.containsKey(messageName)) {
            return messages.get(messageName).getOrDefault(fieldName, "");
        }
        return "";
    }

    public int get_size(String name) {
        if (messages.containsKey(name)) {
            return getSizeOfMessage(name);
        } else {
            return getTypeSize(name);
        }
    }

    private int getSizeOfMessage(String messageName) {
        if (messageSizes.containsKey(messageName)) {
            return messageSizes.get(messageName); // Return cached size if available
        }

        HashMap<String, String> fields = messages.get(messageName);
        int size = 0;
        for (String fieldName : fields.keySet()) {
            size += getFieldSize(messageName, fieldName);
        }
        
        messageSizes.put(messageName, size); // Cache the calculated size
        return size;
    }

    private int getFieldSize(String messageName, String fieldName) {
        if (messages.containsKey(messageName)) {
            String fieldType = messages.get(messageName).get(fieldName);
            if (messages.containsKey(fieldType)) {
                // If fieldType is another message, recursively get its size
                return getSizeOfMessage(fieldType);
            } else {
                return getTypeSize(fieldType);
            }
        }
        return 0;
    }

    private int getTypeSize(String typeName) {
        return typeSizes.getOrDefault(typeName, 0);
    }

    public static void main(String[] args) {
        String input = "Message xxx\n" +
                "int field1\n" +
                "int field2\n" +
                "string field3\n" +
                "float field4\n" +
                "\n" +
                "Message yyy\n" +
                "string field1\n" +
                "float field2\n" +
                "\n" +
                "Message zzz\n" +
                "string field1\n" +
                "yyy field2";

        ProtobufParser parser = new ProtobufParser();
        parser.parseInput(input);

        // Test cases
        testGetType(parser);
        testGetSizeOfMessage(parser);
        testGetTypeSize(parser);
    }

    private static void testGetType(ProtobufParser parser) {
        assertEquals("int", parser.getType("xxx", "field1"));
        assertEquals("string", parser.getType("yyy", "field1"));
        assertEquals("yyy", parser.getType("zzz", "field2"));
        assertEquals("", parser.getType("zzz", "nonExistingField"));
    }

    private static void testGetSizeOfMessage(ProtobufParser parser) {
        assertEquals(268, parser.get_size("xxx")); // 4(int) + 4(int) + 256(string) + 4(float)
        assertEquals(260, parser.get_size("yyy")); // 256(string) + 4(float)
        assertEquals(516, parser.get_size("zzz")); // 256(string) + 260(yyy)
    }

    private static void testGetTypeSize(ProtobufParser parser) {
        assertEquals(4, parser.get_size("int"));
        assertEquals(4, parser.get_size("float"));
        assertEquals(256, parser.get_size("string"));
        assertEquals(0, parser.get_size("nonExistingType"));
    }
}
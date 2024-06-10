//To encode, I iterate through each string in the list,
//appending its length, a delimiter, and the string itself to a StringBuilder.
//To decode, I iterate through the encoded string,
//finding each substring delimited by "/:", where the length of the string is located
//before the delimiter. I extract the string based on its length and add it to a list.
//This process continues until the end of the encoded string is reached.

//Time: n, n is the total number of characters across all strings in the list.
//Space: k, k is the number of strings
public class Codec {
    public String encode(List<String> strs) {
        // Initialize a StringBuilder to hold the encoded string.
        StringBuilder encodedString = new StringBuilder();
        for (String s : strs) {
            // Append the length, the delimiter, and the string itself.
            encodedString.append(s.length()).append("/:").append(s);
        }
        return encodedString.toString();
    }

    public List<String> decode(String s) {
        // Initialize a list to hold the decoded strings.
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // Find the delimiter.
            int delim = s.indexOf("/:", i);
            // Get the length, which is before the delimiter.
            int length = Integer.parseInt(s.substring(i, delim));
            // Get the string, which is of 'length' length after the delimiter.
            String str = s.substring(delim + 2, delim + 2 + length);
            // Add the string to the list.
            decodedStrings.add(str);
            // Move the index to the start of the next length.
            i = delim + 2 + length;
        }
        return decodedStrings;
    }
}
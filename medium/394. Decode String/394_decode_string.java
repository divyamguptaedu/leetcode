"""
Performance:
Runtime: 5 ms, faster than 20.47% of Java online submissions for Decode String.
Memory Usage: 37.3 MB, less than 53.01% of Java online submissions for Decode String.
"""

class Solution {
    public String decodeString(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        String result = "";
        int index = 0;
        Stack<String> stack = new Stack<>();
        char temp;

        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);

            // if the character is a number, then save that number;
            if (Character.isDigit(temp)) {
                index = (index * 10) + (Integer.parseInt(String.valueOf(temp)));
            }
            // if the character is '[', then save the result and get new string;
            else if (temp == '[') {
                stack.push(result);
                stack.push(String.valueOf(index));
                index = 0;
                result = "";
            }
            // if the character is ']', then get the new string and add to the result index times;
            else if (temp == ']') {
                int times = Integer.parseInt(stack.pop());
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    stringBuilder.append(result);
                }
                result = stack.pop() + stringBuilder.toString();
            // if the character is just an alphabet, then add to the result;
            } else {
                result = result + temp;
            }
        }

        return result;
    }
}
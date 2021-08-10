"""
Performance:
Runtime: 5 ms, faster than 20.47% of Java online submissions for Decode String.
Memory Usage: 37.7 MB, less than 26.39% of Java online submissions for Decode String.
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
            if (Character.isDigit(temp)) {
                index = Integer.parseInt(String.valueOf(temp));
            }
            else if (temp == '[') {
                stack.push(result);
                stack.push(String.valueOf(index));
                index = 0;
                result = "";
            }
            else if (temp == ']') {
                int times = Integer.parseInt(stack.pop());
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    stringBuilder.append(result);
                }
                result = stack.pop() + stringBuilder.toString();
            } else {
                result = result + temp;
            }
        }

        return result;
    }
}
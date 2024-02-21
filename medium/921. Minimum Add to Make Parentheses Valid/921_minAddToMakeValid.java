"
Performance:
Runtime: 1 ms, faster than 89.16% of Java online submissions for Minimum Add to Make Parentheses Valid.
Memory Usage: 41.7 MB, less than 71.90% of Java online submissions for Minimum Add to Make Parentheses Valid.
"

class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int error = 0;
        for (char letter : s.toCharArray()) {
            if (letter == '(')
                count++;
            else {
                if (count == 0) {
                    error++;
                } else {
                    count--;
                }
            }
        }
        return error + count;
    }
}

//another solution

class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return left + right;
    }
}
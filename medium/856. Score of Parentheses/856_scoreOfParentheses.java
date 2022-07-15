"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Score of Parentheses.
Memory Usage: 42 MB, less than 46.04% of Java online submissions for Score of Parentheses.
"

class Solution {
    int index = 0;
    public int scoreOfParentheses(String s) {
        int result = 0;
        while (index < s.length()) { 
            if (s.charAt(index) == '(') {
                index++;
                int score = scoreOfParentheses(s);
                result = result + (score == 0 ? 1 : 2 * score);
            } else {
                index++;
                return result;
            }
        }
        return result;
    }
}
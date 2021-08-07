"""
Performance:
Runtime: 1 ms, faster than 72.29% of Java online submissions for Generate Parentheses.
Memory Usage: 39 MB, less than 69.62% of Java online submissions for Generate Parentheses.
"""

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String answer = "";
        int start = 0;
        int end = 0;
        result = helper(start, end, n, answer, result);
        return result;
    }
    
    private List<String> helper(int start, int end, int n, String answer, List<String> result) {
        if (answer.length() == (n + n)) {
            result.add(answer);
            return result;
        }
        String newString;
        int newIndex;
        if (start < n) {
            newString = answer + "(";
            newIndex = start + 1;
            helper(newIndex, end, n, newString, result);
        }
        if (end < start) {
            newString = answer + ")";
            newIndex = end + 1;
            helper(start, newIndex, n, newString, result);
        }
        return result;
    }
}
"""
Performance:
Runtime: 4 ms, faster than 91.44% of Java online submissions for Lexicographical Numbers.
Memory Usage: 46.5 MB, less than 95.67% of Java online submissions for Lexicographical Numbers.
"""

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> lexicalOrder (int n) {
        for (int i = 1; i <= 9; i++) {
            helper(i, n);
        }
        return result;
    }
    
    public void helper (int x, int n) {
        if (x <= n) {
            result.add(x);
        } else {
            return;
        }
        for (int i = 0; i <= 9; i++) {
            helper(x*10 + i, n);
        }
    }
}
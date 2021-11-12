"""
Performance:
Runtime: 16 ms, faster than 75.67% of Java online submissions for Combinations.
Memory Usage: 41.9 MB, less than 41.90% of Java online submissions for Combinations.
"""

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (k == 0) {    
            result.add(new LinkedList());
            return result;
        }
        helper(1, new LinkedList<Integer>(), n, k, result);
        return result;
    }
    public void helper (int start, LinkedList<Integer> current, int n, int k, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new LinkedList(current));
        }
        for (int i = start; i <= n && current.size() < k; i++) {
            current.add(i);
            helper (i + 1, current, n, k, result);
            current.removeLast();
        }
    }
}
"""
Performance:
Runtime: 4 ms, faster than 62.81% of Java online submissions for Kth Largest Element in an Array.
Memory Usage: 39.1 MB, less than 74.98% of Java online submissions for Kth Largest Element in an Array.
"""

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int n : nums) {
        	pq.add(n);
        }
        for (int i = 1; i < k; i++) {
        	pq.poll();
        }
        return pq.poll();
    }
}
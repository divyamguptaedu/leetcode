"""
Performance:
Runtime: 4 ms, faster than 62.81% of Java online submissions for Kth Largest Element in an Array.
Memory Usage: 39.1 MB, less than 74.98% of Java online submissions for Kth Largest Element in an Array.
"""

class Solution {
    public int findKthLargest(int[] nums, int k) {

        // add all n in nums to a max heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int n : nums) {
        	pq.add(n);
        }

        // remove top k - 1;
        for (int i = 1; i < k; i++) {
        	pq.poll();
        }

        // return kth;
        return pq.poll();
    }
}
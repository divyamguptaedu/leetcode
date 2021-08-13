"""
Performance: 
Runtime: 3 ms, faster than 99.45% of Java online submissions for Edit Distance.
Memory Usage: 39.3 MB, less than 34.57% of Java online submissions for Edit Distance.
"""
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        
        int[] result = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0 ; i < n ; i++) {
            while (queue.size() > 0 && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            while (queue.size() > 0 && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return result;

    }
}
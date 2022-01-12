"
Performance:
Runtime: 51 ms, faster than 8.14% of Java online submissions for Minimum Number of K Consecutive Bit Flips.
Memory Usage: 117 MB, less than 16.28% of Java online submissions for Minimum Number of K Consecutive Bit Flips.
"

class Solution {
    public int minKBitFlips(int[] A, int K) {
        int result = 0;
        Queue<Integer> list = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            int cur = A[i] + list.size();
            if (cur % 2 == 0) {
                list.offer(i + K - 1);
                result++;
            }
            while (!list.isEmpty() && list.peek() <= i) {
                list.poll();
            }
        }
        if (!list.isEmpty()) {
            return -1;
        }
        return result;
    }
}
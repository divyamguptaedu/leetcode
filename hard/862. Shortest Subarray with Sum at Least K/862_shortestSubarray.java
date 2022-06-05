class Solution {
    public int shortestSubarray(int[] A, int K) {
        int size = A.length;
        int result = Integer.MAX_VALUE;
        int[] sum = new int[size + 1];
        sum[0] = 0;
        for (int i = 1; i < size + 1; i++) {
            sum[i] = A[i - 1] + sum[i - 1];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < size + 1; i++) { 

            while(!deque.isEmpty() && sum[i] - sum[deque.peekFirst()] >= K) {
                result = Math.min(result, i - deque.peekFirst());
                deque.pollFirst();
            }

            while(!deque.isEmpty() && sum[i] < sum[deque.peekLast()]){
                deque.pollLast();
            }

            deque.offer(i);
        }
        return result == Integer.MAX_VALUE? -1: result;
    }
}
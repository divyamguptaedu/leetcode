"
Performance:
Runtime: 291 ms, faster than 69.46% of Java online submissions for Length of Longest Fibonacci Subsequence.
Memory Usage: 118.4 MB, less than 28.39% of Java online submissions for Length of Longest Fibonacci Subsequence.
"

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int count = 2;
                int one = arr[i];
                int two = arr[j];
                while (hashSet.contains(one + two)) {
                    count++;
                    int temp = one;
                    one = two;
                    two = temp + two;
                }
                if (count >= 3) {
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }
}
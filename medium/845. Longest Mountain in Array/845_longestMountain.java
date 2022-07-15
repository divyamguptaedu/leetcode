"
Performance:
Runtime: 4 ms, faster than 47.52% of Java online submissions for Longest Mountain in Array.
Memory Usage: 52.6 MB, less than 31.82% of Java online submissions for Longest Mountain in Array.
"

class Solution {
    public int longestMountain(int[] arr) {
        int result = 0;
        int minimum = arr.length - 1;
        boolean increasing = false;
        boolean decreasing = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] < arr[i]) {
                if (decreasing) {
                    decreasing = false;
                    minimum = i - 1;
                }
                increasing = true;
                minimum = Math.min(minimum, i - 1);
            } else if (arr[i-1] > arr[i]) {
                if (increasing) {
                    result = Math.max(result, i - minimum + 1);
                }
                decreasing = true;
            } else {
                increasing = false;
                decreasing = false;
                minimum = i;
            }
        }
        return result;
    }
}
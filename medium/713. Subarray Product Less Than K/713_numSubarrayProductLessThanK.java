"
Performance:
Runtime: 7 ms, faster than 69.40% of Java online submissions for Subarray Product Less Than K.
Memory Usage: 72.6 MB, less than 22.16% of Java online submissions for Subarray Product Less Than K.
"

class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if (k < 2) {
            return 0;
        }
        int count = 0;
        int multiplier = 1;
        int start = 0;
        int i;
        for (i = 0; i < arr.length; i++) {
            multiplier = multiplier * arr[i];     
            while (multiplier >= k) {
                multiplier = multiplier / arr[start++];
            }
            count+= i - start + 1;
        }
        return count;
    }
}
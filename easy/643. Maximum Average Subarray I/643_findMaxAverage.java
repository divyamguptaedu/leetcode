class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return (double) nums[0];
        }
        int start = 0;
        int end = k;
        double average = 0;
        for (int i = 0; i < k; i++) {
            average = average + (double) nums[i] / k;
        }
        double max = average;
        while (end < nums.length) {
            average = average - (double) nums[start++] / k;
            average = average + (double) nums[end++] / k;
            max = Math.max(average, max);
        }
        return max;
    }
}
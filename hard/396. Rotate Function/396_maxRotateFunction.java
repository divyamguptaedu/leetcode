class Solution {
    public int maxRotateFunction(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int fArray[] = new int[nums.length];
        int sum = 0;
        int iteration = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            fArray[0] += i * nums[i];
        }
        
        int max = fArray[0];

        for (int j = 1; j < n; j++) {
            fArray[j] = fArray[j - 1] - sum + nums[j - 1] * n;
            max = Math.max(max, fArray[j]);
        }
        
        return max;
    }
}
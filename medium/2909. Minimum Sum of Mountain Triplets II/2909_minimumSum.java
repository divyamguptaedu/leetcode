class Solution {
    public int minimumSum(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] inputR = new int[length];
        int initial = nums[0];
        helper(inputR, nums);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] > initial && nums[i] > inputR[i + 1]) {
                result = Math.min(result, initial + nums[i]+ inputR[i + 1]);
            }
            initial = Math.min(initial, nums[i]);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private void helper(int[] input, int nums[]) {
        input[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            input[i] = Math.min(input[i + 1], nums[i]);
        }
    }
}
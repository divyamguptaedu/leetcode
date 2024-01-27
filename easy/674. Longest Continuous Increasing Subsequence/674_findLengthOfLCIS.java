class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int counter = 1;
        int result = 1;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                counter = counter + 1;
            } else {
                counter = 1; 
            }
            if (result < counter) {
                result = counter;
            }
        }
        return result;
    }
}
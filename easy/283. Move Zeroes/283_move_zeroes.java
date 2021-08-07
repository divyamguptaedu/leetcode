"""
Performance:
Runtime: 6 ms, faster than 7.49% of Java online submissions for Move Zeroes.
Memory Usage: 39 MB, less than 80.84% of Java online submissions for Move Zeroes.
"""

class Solution {

    public void moveZeroes(int[] nums) {
        // int j will not be changed if there's a zero to move.
        int j = 0;
        // loop runs num.length - 1 times.
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] == 0) {
                nums = takeZeroToEnd(j, nums);
            } else {
                j++;
            }
        }
    }
    
    // helper function to move zero at index to end and return updated array.
    private int[] takeZeroToEnd(int index, int[] nums) {
        int temp;
        while (index < nums.length - 1) {
            temp = nums[index + 1];
            nums[index] = temp;
            index++;
        }
        nums[index] = 0;
        return nums;
    }
}
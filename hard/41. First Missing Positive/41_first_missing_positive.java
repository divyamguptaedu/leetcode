"""
Performance:
Runtime: 2 ms, faster than 89.11% of Java online submissions for First Missing Positive.
Memory Usage: 96.4 MB, less than 59.84% of Java online submissions for First Missing Positive.
"""

class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int j;
        int n = nums.length;
        
        // handle case of a single-element array
        if (n == 1) {
            if (nums[i] == 1) return 2;
            else return 1;
        }
        
        // try to place numbers in their correct indices
        while (i < n) {  
            // ignore numbers out of range (negative numbers and numbers greater than length of the array)
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        
        // loop through the array again
        // find the first number that is not at its correct index
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
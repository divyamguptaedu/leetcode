"""
Performance:
Runtime: 9 ms, faster than 38.41% of Java online submissions for Wiggle Sort II.
Memory Usage: 56.8 MB, less than 5.04% of Java online submissions for Wiggle Sort II.
"""

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int[] result = new int[size];
        int i = 1;
        int j = size - 1;
        while (i < size){
            result[i] = nums[j];
            i += 2;
            j--;
        }
        i = 0;
        while (i < size){
            result[i] = nums[j];
            i += 2;
            j--;
        }
        
        for (int k = 0; k < size; k++) {
            nums[k] = result[k];
        }
    }
}
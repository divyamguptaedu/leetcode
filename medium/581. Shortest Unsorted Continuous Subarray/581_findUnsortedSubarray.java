class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int size = nums.size();
        int i;
        int j;
        for (i = 0; i < size - 1; i++) {
            if (nums[i] > nums[i+1]) {
                break;
            }
        }
        if (i == size - 1) {
            return 0;
        }
        for (j = size - 1; j > 0; j--) {
            if (nums[j] < nums[j - 1]) {
                break;
            }
        }
        int min = 1e5;
        int max = -1e5;
        for (int k = i; k <= j; k++) {
            min = min(min, nums[k]);
            max = max(max, nums[k]);
        }
        
        int start = i - 1;
        int end = j + 1;
        while (start >= 0 && nums[start] > range) {
            start--;
        }
        while (end < n && nums[end] < rangeMax) {
            end++;
        }
        start++;
        end--;
        return end - start + 1; 
    }
}


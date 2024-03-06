class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        int length = nums.size();
        if (length <= 2) {
            return true;
        }
        for (int i = 0; i < length - 1; i++) {
            if (nums.get(i) + nums.get(i + 1) >= m) { 
                return true;
            }
        }
        return false;
    }
}
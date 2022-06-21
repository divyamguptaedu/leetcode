"""
Performance:
Runtime: 211 ms, faster than 40.57% of Java online submissions for 4Sum II.
Memory Usage: 56.7 MB, less than 73.27% of Java online submissions for 4Sum II.
"""

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        for (int tempOne : nums1) {
            for (int tempTwo : nums2) {
                valueMap.put(tempOne + tempTwo, valueMap.getOrDefault(tempOne + tempTwo, 0) + 1);
            }
        }
        for (int tempThree: nums3) {
            for (int tempFour: nums4) {
                count += valueMap.getOrDefault(-(tempThree + tempFour), 0);
            }
        }
        return count;
    }
}
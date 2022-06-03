"
Performance:
Runtime: 60 ms, faster than 14.97% of Java online submissions for Contains Duplicate II.
Memory Usage: 94.5 MB, less than 25.45% of Java online submissions for Contains Duplicate II.
"

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> valueMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valueMap.containsKey(nums[i]) && i - valueMap.get(nums[i]) <= k) {
                return true;
            } else {
                valueMap.put(nums[i],i);
            }
        }
        return false;

    }
}
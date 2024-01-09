"""
Performance:
Runtime: 17 ms, faster than 30.29% of Java online submissions for Find All Numbers Disappeared in an Array.
Memory Usage: 55.3 MB, less than 12.41% of Java online submissions for Find All Numbers Disappeared in an Array.
"""

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
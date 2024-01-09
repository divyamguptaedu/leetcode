"""
Performance:
Runtime: 22 ms, faster than 12.44% of Java online submissions for Find All Numbers Disappeared in an Array.
Memory Usage: 48.9 MB, less than 17.21% of Java online submissions for Find All Numbers Disappeared in an Array.
"""

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // add all int in nums to a hashmap.
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        int value;
        for (int i = 0; i < nums.length; i++) {
            if (valueMap.get(nums[i]) == null) {
                valueMap.put(nums[i], 1);
            } else {
                value = valueMap.get(nums[i]);
                value++;
                valueMap.put(nums[i], value);
            }
        }
        // return all int in range not found in the hashmap.
        ArrayList<Integer> disappearedList = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (valueMap.get(i) == null) {
                disappearedList.add(i);
            }
        }
        return disappearedList;
    }
}
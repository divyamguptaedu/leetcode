"""
Performance:
Runtime: 10 ms, faster than 22.22% of Java online submissions for Majority Element.
Memory Usage: 44.2 MB, less than 63.75% of Java online submissions for Majority Element.
"""

class Solution {
    public int majorityElement(int[] nums) {

        // create hashmap for each distinct int in array and update its frequency.
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            if (valueMap.get(nums[i]) == null) {
                valueMap.put(nums[i], 1);
                value = 1;
            } else {
                value = valueMap.get(nums[i]);
                value++;
                valueMap.put(nums[i], value);
            }

            // return int if its frequency fulfills the condition.
            if (value > (nums.length / 2)) {
                return nums[i];
            }
        }
        return value;
    }
}
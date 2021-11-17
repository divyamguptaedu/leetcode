"""
Performance:
Runtime: 3 ms, faster than 59.32% of Java online submissions for Single Number II.
Memory Usage: 38.7 MB, less than 67.17% of Java online submissions for Single Number II.
"""

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i])+1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            for (Integer key : map.keySet()) {
                if (map.get(key) == 1) {
                    return key;
                }
            }
        return -1;
    }
}
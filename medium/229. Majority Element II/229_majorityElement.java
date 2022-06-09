"""
Performance:
Runtime: 22 ms, faster than 66.66% of Java online submissions for Majority Element II.
Memory Usage: 48.2 MB, less than 71.98% of Java online submissions for Majority Element II.
"""

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.replace(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        int temp = nums.length/3;
        for (Integer majorElements : hashMap.keySet()) {
            if (hashMap.get(majorElements) > temp) {
                list.add(majorElements);
            }
        }
        return list;
    }
}
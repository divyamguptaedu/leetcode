"""
Performance:
Runtime: 37 ms, faster than 9.70% of Java online submissions for Find All Duplicates in an Array.
Memory Usage: 66.1 MB, less than 54.99% of Java online submissions for Find All Duplicates in an Array.
"""

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> valueMap = new HashMap<>();
        for (int num : nums) {
            valueMap.put(num, valueMap.getOrDefault(num, 0) + 1);
            if (valueMap.get(num) == 2) {
                result.add(num);
            }
        }
        return result;
    }
}
"
Performance:
Runtime: 18 ms, faster than 56.03% of Java online submissions for Binary Subarrays With Sum.
Memory Usage: 45.7 MB, less than 96.52% of Java online submissions for Binary Subarrays With Sum.
"

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            valueMap.put(sum, valueMap.getOrDefault(sum, 0) + 1);
            sum += nums[i];
            if (valueMap.containsKey(sum - goal)) 
                result += valueMap.get(sum - goal);
        }
        return result;
    }
}
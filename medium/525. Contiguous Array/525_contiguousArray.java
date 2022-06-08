"
Runtime: 25 ms, faster than 85.74% of Java online submissions for Contiguous Array.
Memory Usage: 51.5 MB, less than 83.76% of Java online submissions for Contiguous Array.
"

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        HashMap <Integer, Integer> valueMap = new HashMap <> ();
        valueMap.put(0, -1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ? -1 : 1);
            if (valueMap.containsKey(sum)) {
                int end = valueMap.get(sum);
                result = Math.max(result, i - end);
            } else {
                valueMap.put(sum, i);
            }
        }
        return result;
    }
}
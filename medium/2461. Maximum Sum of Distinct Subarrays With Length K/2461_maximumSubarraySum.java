//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0L;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        long result = 0L;
        if (map.size() == k) {
            result = sum;
        }

        for (int i = k; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
            sum -= nums[i - k];
            map.put(nums[i - k], map.get(nums[i - k]) - 1);

            if (map.get(nums[i - k]) == 0) {
                map.remove(nums[i - k]);
            }
            if (map.size() == k) {
                result = Math.max(result, sum);
            }
        }
        
        return result;
    }
}
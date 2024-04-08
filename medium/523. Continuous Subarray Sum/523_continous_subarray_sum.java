class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        map.put(0, -1); //To account for sum to be 0. 
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (map.containsKey(remainder)) {
                if ((i - map.get(remainder)) > 1) {
                    return true;
                } else {
                    continue;
                }
            }   
            map.put(remainder, i);
        }

        return false;
    }
}
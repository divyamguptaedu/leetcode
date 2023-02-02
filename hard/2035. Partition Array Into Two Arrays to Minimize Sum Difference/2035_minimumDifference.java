class Solution {
    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
    
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, 0, 0, list);
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= list.size() / 2; i++) { 
            ans = Math.min(ans, Math.abs(sum - list.get(i) - list.get(i)));
        }
        
        return ans;
    }

    private void helper(int[] nums, int i, int sum, int l, List<Integer> list) {
        if (l == nums.length / 2) {
            list.add(sum);
            return;
        }
        if (i == nums.length) {
            return;
        }
    
        helper(nums, i + 1, sum + nums[i], l + 1, list);
        helper(nums, i + 1, sum, l, list);
    }
}
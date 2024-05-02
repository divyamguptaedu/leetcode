class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int j = 0;
        long max = 0;
        long[] pre = new long[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + (long)nums[i];
        }
        long sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(nums[i]) && hm.get(nums[i]) >= j) {
                sum = pre[i] - pre[hm.get(nums[i])];
                j = hm.get(nums[i]);
                j++;
            } else {
                sum += (long)nums[i];
            }
            hm.put(nums[i], i);
            if (i - j + 1 == k) {
                max = Math.max(max, sum);
                sum -= nums[j];
                j++;
            }
            // System.out.println(sum);
        }
        return (long)max;

    }
}
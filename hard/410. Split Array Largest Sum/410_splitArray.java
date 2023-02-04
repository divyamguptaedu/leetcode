class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m == 0 ) {
            return 0;
        }
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            max = Math.max(num, max);
        }
        if (m == nums.length) {
            return max;
        } else if ( m == 1 ) {
            return sum;
        } else {
            int ans = 0;
            int lo = max;
            int hi = sum;
            while (lo <= hi) {
                int mid = lo + ( hi-lo )/2;
                if (isPossible(nums, mid, m)) {   
                    ans = mid;
                    hi = mid - 1; 
                } else {
                    lo = mid + 1;
                }
            }
            return ans;
        }
    }
    
    public static boolean isPossible ( int[] nums, int mid, int m ) {
        int sum = 0;
        int requiredSubarrays = 1;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum > mid) {
                requiredSubarrays++;
                sum = nums[i];
            }
        }
        if (requiredSubarrays <= m) {
            return true;
        }
        return false;
    }
}
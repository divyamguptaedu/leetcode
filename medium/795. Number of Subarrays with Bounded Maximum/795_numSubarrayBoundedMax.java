"
Performance:
Runtime: 3 ms, faster than 100.00% of Java online submissions for Number of Subarrays with Bounded Maximum.
Memory Usage: 70.6 MB, less than 18.49% of Java online submissions for Number of Subarrays with Bounded Maximum.
"

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int total = 0;
        int cut = -1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num > right) {
                count = 0;
                cut = i;
            } else if(num < left) {
                total += count;
            } else {
                count = i - cut;
                total += count;
            }
        }
        return total;
    }
}
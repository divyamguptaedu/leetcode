class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zeroCount1 = 0;
        int zeroCount2 = 0;
        long sum1 = 0;
        long sum2 = 0;
        for (int num : nums1) {
            if (num == 0) {
                zeroCount1++;
                sum1 += 1;
            } else {
                sum1 += num;
            }
        }
        for (int num : nums2) {
            if (num == 0) {
                zeroCount2++;
                sum2 += 1;
            } else {
                sum2 += num;
            }
        }

        if (zeroCount1 == 0 && sum1 < sum2 || zeroCount2 == 0 && sum1 > sum2) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}

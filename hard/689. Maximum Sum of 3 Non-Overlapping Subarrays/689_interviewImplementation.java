import java.util.Arrays;

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];

        // Calculate prefix sums
        int cur = 0;
        for (int i = 0; i < len; i++) {
            cur += nums[i];
            preSum[i] = cur;
        }

        // Calculate left array
        int localSum = Integer.MIN_VALUE;
        for (int i = k - 1; i < len; i++) {
            int sum = preSum[i] - (i >= k ? preSum[i - k] : 0);
            if (sum > localSum) {
                localSum = sum;
                left[i] = i - k + 1;
            } else {
                left[i] = left[i - 1];
            }
        }

        // Calculate right array
        localSum = Integer.MIN_VALUE;
        for (int i = len - k; i >= 0; i--) {
            int sum = preSum[i + k - 1] - (i > 0 ? preSum[i - 1] : 0);
            if (sum >= localSum) {
                localSum = sum;
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }

        // Calculate the result
        localSum = Integer.MIN_VALUE;
        int[] res = new int[3];
        for (int i = k; i <= len - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            int leftSum = preSum[l + k - 1] - (l > 0 ? preSum[l - 1] : 0);
            int midSum = preSum[i + k - 1] - preSum[i - 1];
            int rightSum = preSum[r + k - 1] - (r > 0 ? preSum[r - 1] : 0);
            int total = leftSum + midSum + rightSum;
            if (total > localSum) {
                localSum = total;
                res = new int[] { l, i, r };
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 1, 2, 6, 7, 5, 1};
        int k1 = 2;
        int[] result1 = solution.maxSumOfThreeSubarrays(nums1, k1);
        System.out.println("Indices of maximum sum of 3 non-overlapping subarrays (Test 1): " + Arrays.toString(result1));

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k2 = 3;
        int[] result2 = solution.maxSumOfThreeSubarrays(nums2, k2);
        System.out.println("Indices of maximum sum of 3 non-overlapping subarrays (Test 2): " + Arrays.toString(result2));

        int[] nums3 = {4, 5, 10, 2, 4, 9, 1, 5, 6};
        int k3 = 1;
        int[] result3 = solution.maxSumOfThreeSubarrays(nums3, k3);
        System.out.println("Indices of maximum sum of 3 non-overlapping subarrays (Test 3): " + Arrays.toString(result3));
    }
}
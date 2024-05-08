//We can use binary search to solve this question. To find the range imagine a matrix full of 1s, so m is the minimum sum.
//For max sum, imagine a matrix full of 5000s (max given in constraints), so 5000m is the max sum. We do binary search on this. 
//We find the mid value and then check how many numbers do we have which are less than this mid sum.
//If that count is >= k, we chose the left half, save the sum. Otherwise, we chose the right half.
//Now, to find the #elements less than a sum, we can use a recursive helper method which will take O(mn) time.

//Time: O(mnlogm) mn for recursive less_than method, and logm for binary search for mid sum value.
//Space: O(m)
class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int left = m;
        int right = 5000 * m;
        int sum = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = less_than(mat, mid, 0, k);
            if (cnt >= k) {
                right = mid - 1;
                sum = mid;
            } else
                left = mid + 1;
        }
        return sum;
    }

    public int less_than(int[][] mat, int sum, int idx, int k) {
        if (sum < 0)
            return 0;
        if (idx == mat.length)
            return 1;
        int ans = 0;
        for (int j = 0; j < mat[0].length; j++) {
            int cnt = less_than(mat, sum - mat[idx][j], idx + 1, k - ans);
            if (cnt == 0)
                break;
            ans += cnt;
            if (ans > k)
                break;
        }
        return ans;
    }
}

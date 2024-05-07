class Solution {
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

    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int left = m, right = 5000 * m, sum = 0;
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
}

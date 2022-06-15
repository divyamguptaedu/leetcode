"
Performance:
TLE
"

class Solution {
    public int kInversePairs(int n, int k) {
        int[][] result = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if(j == 0) {
                    result[i][j] = 1;
                } else {
                    for (int l = 0; l <= Math.min(j, i - 1); l++) {
                        result[i][j] = (result[i][j] + result[i - 1][j - l]) % 1000000007;
                    }
                }
            }
        }
        return result[n][k];
    }
}
}
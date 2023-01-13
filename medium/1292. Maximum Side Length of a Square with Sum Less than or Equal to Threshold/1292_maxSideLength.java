class Solution {
	public int maxSideLength(int[][] mat, int threshold) {
		int length = 0;
		int x = mat.length;
		int y = mat[0].length;
		for (int i = 0; i < x - length; i++) {
			for (int j =0 ;j < y - length; j++) { 
				if (mat[i][j] <= threshold) {
					length = Math.max(dp(mat, threshold, i, j, mat[i][j], 1), length);
				}
			}
		}
		return length;
	}
	public int dp(int[][] mat, int m, int x , int y , int sum , int length) {
		if (x + length <= mat.length && y + length < mat[1].length) {
			sum = sum - mat[x + length][y + length];
			for (int i = x; i < x + length + 1; i++) {
				sum = sum + mat[i][y + length];
			}
			for (int j = y; j < y + length + 1; j++) {
				sum = sum + mat[x + length][j];
			}
		if (sum > m) {
			return length;
		}
		return dp(mat,m,x,y,sum,length+1);
		}
		return length;
	}
}
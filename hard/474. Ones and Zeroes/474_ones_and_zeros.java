"""
Performance:
Runtime: 35 ms, faster than 69.83% of Java online submissions for Ones and Zeroes.
Memory Usage: 42.8 MB, less than 57.45% of Java online submissions for Ones and Zeroes.
"""

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length < 1) {
            return 0;
        }
        int[][] array = new int[m + 1][n + 1];
        int[][] nums = new int[strs.length][2];
        for (int i = 0; i < strs.length; ++i) {
            for (int j = 0; j < strs[i].length(); ++j) {
                nums[i][strs[i].charAt(j) - '0']++;
            }
        }
        for (int[] num : nums) {
            for (int i = m; i >= num[0]; --i) {
                for (int j = n; j >= num[1]; --j) {
                    array[i][j] = Math.max(array[i][j], 1 + array[i - num[0]][j - num[1]]);
                }
            }
        }
        return array[m][n];
    }
}
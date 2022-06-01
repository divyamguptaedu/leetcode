/*
Runtime: 5 ms, faster than 34.34% of Java online submissions for Find the Town Judge.
Memory Usage: 68.5 MB, less than 67.22% of Java online submissions for Find the Town Judge.
*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n + 1];
        for (int[] t : trust) {
            degree[t[0]]--;
            degree[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
class Solution {
    public int videoStitching(int[][] clips, int time) {
        Integer[][] dp = new Integer[time + 1][clips.length + 1];
        for (Integer[] row: dp) {
            row[0] = -1;
        }
        Arrays.fill(dp[0], 0);
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        return helper(clips, time, clips.length, dp);
    }
    
    private int helper(int[][] clips, int time, int size, Integer[][] dp) {
        if (dp[time][size] != null) {
            return dp[time][size];
        }
        int skip = helper(clips, time, size - 1, dp);
        int[] newClip = clips[size - 1];
        int take = -1;
        if (newClip[0] < time && newClip[1] >= time) {
            take = helper(clips, newClip[0], size - 1, dp);
        }
        int result = -1;
        if (skip == -1 && take != -1) {
            result = 1 + take;
        } else if (skip != -1 && take == -1){
            result = skip;
        } else if (skip != -1 && take != -1) {
            result = Math.min(skip, 1 + take);
        }
        dp[time][size] = result;
        return result;
    }
}
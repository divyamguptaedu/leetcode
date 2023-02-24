class Solution {
    class Jobs{
        int start;
        int end;
        int profit;

        Jobs (int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Jobs[] jobs = new Jobs[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Jobs(startTime[i],endTime[i],profit[i]);
            dp[i] = -1;
        }
        Arrays.sort(jobs,(a,b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        return helper(jobs, 0, dp);
    }

    public int helper(Jobs[] jobs, int index, int[] dp){
        if (index >= jobs.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int j = index + 1;
        while (j<jobs.length && jobs[index].end > jobs[j].start) {
            j++;
        }
        dp[index] = Math.max(helper(jobs, j, dp) + jobs[index].profit, helper(jobs, index + 1, dp));
        return dp[index];
    }
}
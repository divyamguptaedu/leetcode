class Solution {
    Long [] dp;
    public long maxTaxiEarnings(int n, int[][] rides) {
        dp = new Long[rides.length+1];
        Arrays.sort(rides, (a,b) -> a[0] - b[0]);
        return helper(n, rides, 0, 1);
    }
    
    public long helper(int n, int [][] rides, int i, int stop) {
        if (stop > n || i == rides.length) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int start = rides[i][0];
        int end = rides[i][1] ;
        int tip =  rides[i][2];
        long take = (end - start) + tip + helper(n, rides, find(rides,i), stop + 1);
        long notTake =  helper(n,rides, i+1, stop);
        long max = Math.max(take, notTake);
        return dp[i]= max;
    }
    public int find (int [][] rides, int end) {
        int low = end + 1;
        int high =  rides.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (rides[mid][0] >= rides[end][1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
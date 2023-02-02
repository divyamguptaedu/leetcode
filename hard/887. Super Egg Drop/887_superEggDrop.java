class Solution {
    int[][] dp;
    public int superEggDrop(int k, int n) {
        dp = new int[k + 1][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i , -1);
        }
       return solve(k , n);
    }
    
    private int solve(int e , int f) { 
        if (f == 0 || f == 1 || e == 1) {
           return f;
        }
        if (dp[e][f] != -1) {
            return dp[e][f];
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = f; 
        while (start <= end) {
            int k = start + (end-start) /2;
            int left = solve(e - 1 , k - 1);
            int right = solve(e , f - k);
            int temp = 1 + Math.max(left , right); 
            min = Math.min(min , temp);
            if (left < right) {
                start = k + 1;
            } else {
                end = k - 1;
            }            
        }
        return dp[e][f] = min;
    }
}
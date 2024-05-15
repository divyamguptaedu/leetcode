//To solve the Coin Change problem, I utilized dynamic programming. 
//I created an array dp of size amount + 1 to store the minimum number of coins required to make up each amount. 
//I initialized all elements in dp except dp[0] to amount + 1. 
//Then, I iterated over each amount from 1 to amount and for each coin denomination, 
//I updated dp[i] if i can be formed using the current coin, by taking the minimum of dp[i] and dp[i - coins[j]] + 1. 
//Finally, I returned dp[amount] if it's less than dp.length, otherwise -1.

//Time: O(Sn) where S is the amount and n is the size of coins.
//Space: O(S)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp.length; //unreachable state, higher than possible
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == dp.length) {
            return -1;
        } 
        return dp[amount];
    }
}
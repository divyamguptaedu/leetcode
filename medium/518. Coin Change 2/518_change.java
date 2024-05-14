//I initialized an array dp to track the number of combinations for each amount from 0 to the target amount. 
//Then, I iterated through the coins from the largest denomination to the smallest, 
//updating dp[j] for each amount j by adding the number of combinations from the previous amount j - coins[i]. 

//Time: O(n * amount) where n is the size of the coins array 
//Space: O(amount)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
"
Performance:
Runtime: 16 ms, faster than 13.34% of Java online submissions for Best Time to Buy and Sell Stock with Cooldown.
Memory Usage: 117.6 MB, less than 5.02% of Java online submissions for Best Time to Buy and Sell Stock with Cooldown.
"

class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[][] result = new int[size + 2][size + 1];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if(j == 1) {
                    result[i][j] = Math.max(-prices[i] + result[i + 1][0], 0 + result[i + 1][1]);
                }
                else {
                    result[i][j] = Math.max(prices[i] + result[i + 2][1], 0 + result[i + 1][0]);
                }
            }
        }
        return result[0][1];
    }
}
"
Performance:
Runtime: 6 ms, faster than 50.11% of Java online submissions for Best Time to Buy and Sell Stock IV.
Memory Usage: 42.5 MB, less than 51.68% of Java online submissions for Best Time to Buy and Sell Stock IV.
"

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        
        int[] profits = new int[prices.length];
        while (k > 0) {
            int[] upcoming = new int[prices.length];
            int maximum = 0;
            int difference = Integer.MIN_VALUE;
            for (int i = 1; i < prices.length; i++) {
                difference = Math.max(difference, profits[i - 1] - prices[i - 1]);
                maximum = Math.max(maximum, Math.max(profits[i], prices[i] + difference));
                upcoming[i] = maximum;
            }
            profits = upcoming;
            k--;
        }
        return profits[profits.length - 1];
        
    }
}
}
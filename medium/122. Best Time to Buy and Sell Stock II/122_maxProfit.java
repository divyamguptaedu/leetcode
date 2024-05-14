//We can solve this question in a simple one pass.
//I iterated through the price array, comparing each day's price with the previous day's. 
//If the current day's price is higher than the previous day's, I calculated the profit and added it to the total maximum profit. 

//Time: O(n)
//Space: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}
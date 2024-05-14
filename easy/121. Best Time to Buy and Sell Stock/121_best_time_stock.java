//Iterated through the prices array, tracking the minimum price seen so far. 
//For each price, it calculates the profit by subtracting the minimum price from the current price. 
//It updates the maximum profit if a higher profit is found. 
//By traversing the array only once, it determines the optimal buy and sell days, maximizing profit. 

//Time: O(n)
//Space: O(1)
public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
"""
Performance:
Runtime: 4 ms, faster than 83.53% of Java online submissions for Best Time to Buy and Sell Stock III.
Memory Usage: 75.5 MB, less than 72.57% of Java online submissions for Best Time to Buy and Sell Stock III.
"""

class Solution {
    public int maxProfit(int[] prices) {
        int first = Integer.MIN_VALUE;
        int tempOne = 0;
        int second = Integer.MIN_VALUE;
        int tempTwo = 0;
        for (int i = 0; i < prices.length; i++) {
            first = Math.max(first, -prices[i]);
            tempOne = Math.max(tempOne,first + prices[i]);
            second = Math.max(second, tempOne - prices[i]);
            tempTwo = Math.max(tempTwo,second + prices[i]);
        }
        return tempTwo;
    }
}


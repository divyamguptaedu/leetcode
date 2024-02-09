class Solution {
    public int maxProfit(int[] prices) {
        int minimum = prices[0];
        int maximum = 0;
        for (int p : prices) {
            minimum = Math.min(minimum, p);
            maximum = Math.max(maximum, p - minimum);
        }
        return maximum;
    }
}

//another solution

class Solution {
    public int maxProfit(int[] prices) {
        int minimum = prices[0];
        int x = 0; 
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minimum > prices[i]) {
                minimum = prices[i];
            }
            x = prices[i] - minimum;
            if (result < x) {
                result = x;
            }
        }
        return result;
    }
}
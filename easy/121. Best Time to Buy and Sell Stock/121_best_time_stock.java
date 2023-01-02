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

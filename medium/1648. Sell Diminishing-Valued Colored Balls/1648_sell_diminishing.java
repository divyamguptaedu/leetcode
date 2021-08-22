"
Performance:
Runtime: 22 ms, faster than 84.28% of Java online submissions for Sell Diminishing-Valued Colored Balls.
Memory Usage: 53.5 MB, less than 64.12% of Java online submissions for Sell Diminishing-Valued Colored Balls.
"

class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int mod = 1000000007;
        Arrays.sort(inventory);
        int curIndex = inventory.length - 1;
        int curValue = inventory[curIndex];
        long profit = 0;
        while (orders > 0) {
            while (curIndex >= 0 && inventory[curIndex] == curValue) {
                curIndex--;
            }
            // if all colors of balls are the same value, nextValue is 0
            int nextValue = curIndex < 0 ? 0 : inventory[curIndex];
            // number of colors of balls with same value 
            int numSameColor = inventory.length - 1 - curIndex;
            // number of items to buy
            int nums = (curValue - nextValue) * numSameColor;
            if (orders >= nums) {
                // buy all items
                profit += (long)(curValue + nextValue + 1) * (curValue - nextValue) / 2 * numSameColor;
            } else {
			    // orders left is less than the number of items to buy
                int numFullRow = orders / numSameColor;
                int remainder = orders % numSameColor;
                profit += (long)(curValue + curValue - numFullRow + 1) * numFullRow / 2 * numSameColor;
                profit += (long)(curValue - numFullRow) * remainder;
            }
            orders -= nums;
            profit = profit % mod;
            curValue = nextValue;
        }
        return (int)profit;
    }
}
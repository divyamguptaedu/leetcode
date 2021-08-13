"""
Performance: 
Runtime: 108 ms, faster than 8.14% of Java online submissions for Coin Change.
Memory Usage: 40.5 MB, less than 12.68% of Java online submissions for Coin Change.
"""

class Solution {
	public int coinChange(int[] coins, int amount) {
        Map<Integer,Integer> valueMap = new HashMap<>();
        return coinChange(coins, amount, valueMap);
    }
    private int coinChange(int[] coins, int amount, Map<Integer,Integer> valueMap) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        Integer tempOne = valueMap.get(amount);
        if (tempOne != null) {
            return tempOne;
        }
        int tempTwo = -1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coinChange(coins, amount - coins[i], valueMap);
            if (coin >= 0) {
                if (tempTwo < 0) {
                    tempTwo = coin + 1;
                } else {
                    tempTwo = Math.min(tempTwo, coin + 1);
                }
            }
        }
        valueMap.put(amount, tempTwo);
        return tempTwo;
    }
}
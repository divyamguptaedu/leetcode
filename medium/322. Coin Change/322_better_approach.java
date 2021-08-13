""" 
Performance: 
Runtime: 11 ms, faster than 94.44% of Java online submissions for Coin Change.
Memory Usage: 38.5 MB, less than 62.82% of Java online submissions for Coin Change.
"""

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int length = coins.length; 
        int maximum = amount + 1;
        int[] storage = new int[maximum];
        Arrays.fill(storage, maximum);
        storage[0] = 0;

        for (int i = 1; i <= length; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                if (j >= coin) {
                    storage[j] = Math.min(storage[j], storage[j - coin] + 1);
                }
            }
        }
        
        if (storage[amount] >= maximum) {
            return -1;
        } else {
            return storage[amount];
        }
    }
}
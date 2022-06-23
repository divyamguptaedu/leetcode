"
Performance:
Runtime: 3 ms, faster than 93.06% of Java online submissions for Coin Change 2.
Memory Usage: 42.1 MB, less than 63.76% of Java online submissions for Coin Change 2.
"

class Solution {
    public int change(int amt, int[] coins) {
        int[] result = new int[amt + 1];
        result[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            int value = coins[i];
            for (int j = value; j < result.length; j++) {
                result[j] += result[j - value];
            }
        }

        return result[amt];
    }
}
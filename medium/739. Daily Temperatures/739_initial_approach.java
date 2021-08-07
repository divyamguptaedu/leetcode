"""
Performance:
Runtime: 1021 ms, faster than 13.13% of Java online submissions for Daily Temperatures.
Memory Usage: 49.1 MB, less than 49.37% of Java online submissions for Daily Temperatures.
"""

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        boolean found = false;
        for (int i = 0; i < temperatures.length; i++) {
            found = false;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    found = true;
                    break;
                } else {
                    continue;
                }
            }
            if (!found) {
                result[i] = 0;
            }
        }
        return result;
    }
}
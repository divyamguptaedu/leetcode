"""
Performance: 
Runtime: 8 ms, faster than 24.46% of Java online submissions for Permutation Sequence.
Memory Usage: 37.3 MB, less than 40.94% of Java online submissions for Permutation Sequence.
"""

class Solution {
    public String getPermutation(int n, int k) {

        int[] factorials = new int[n];
        factorials[0] = 1;
        
        for (int i = 1; i < factorials.length; i++) {
            factorials[i] = i * factorials[i - 1];
        }

        boolean[] used = new boolean[n];
        int remainder = k - 1;
        String result = "";

        for (int i = n - 1; i >= 0; i--) {
            int leftOut = remainder / factorials[i];
            for (int j = 0; j < used.length; ++j) {
                if (used[j]) {
                    continue;
                }
                if (leftOut == 0) {
                    result += j + 1;
                    used[j] = true;
                    break;
                }
                leftOut--;
            }
            remainder %= factorials[i];
        }
        return result;
    }
}
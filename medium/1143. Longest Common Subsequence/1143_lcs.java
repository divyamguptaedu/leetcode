class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text2.length() < text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        int[] prev = new int[text1.length() + 1];
        int[] curr = new int[text1.length() + 1];
        for (int col = text2.length() - 1; col >= 0; col--) {
            for (int row = text1.length() - 1; row >= 0; row--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    curr[row] = 1 + prev[row + 1];
                } else {
                    curr[row] = Math.max(prev[row], curr[row + 1]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[0];
    }
}
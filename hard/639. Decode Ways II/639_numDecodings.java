class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = calculateWays(s.charAt(0));

        for (int i = 2; i <= n; i++) {
            long oneCharCase = (long) calculateWays(s.charAt(i - 1)) * dp[i - 1];
            long twoCharCase = calculateWaysTwo(s.charAt(i - 2), s.charAt(i - 1)) * dp[i - 2];
            dp[i] = (int) ((oneCharCase + twoCharCase) % (1e9 + 7));
        }
        return dp[n];
    }

    private int calculateWays(char c) {
        if (c == '*') {
            return 9;
        } else if (c == '0') {
            return 0;
        } else {
            return 1;
        }
    }

    private int calculateWaysTwo(char c1, char c2) {
        if (c1 == '*' && c2 == '*') {
            return 15;
        } else if (c1 == '*') {
            if (c2 > 6) {
                return 1;
            } else {
                return 2;
            }
        } else if (c2 == '*') {
            if (c1 == '1') {
                return 9;
            } else if (c1 == '2') {
                return 6;
            }
        } else {
            int ways = Integer.parseInt("" + c1 + c2);
            if (ways >= 10 && ways <= 26) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }
}
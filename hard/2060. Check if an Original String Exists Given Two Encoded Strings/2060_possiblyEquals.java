//We use 2 pointers, i and j, to keep track of the current position within each string.
//We maintain the balance of characters to skip in the variable diff. This value is updated whenever we encounter a number in one of the strings. Numbers from s1 are added to diff, while numbers from s2 are subtracted.
//There are multiple valid ways to process subsequent digits, leading to multiple branches in our decision tree. For instance, the digits in a123z can be processed as 123, 24 (1 + 23), 15 (12 + 3), or 6 (1 + 2 + 3). Each case is handled in a separate recursive call.
//If neither of the current characters (s1[i] and s2[j]) is a digit, we continue skipping characters until we restore a 0 balance in diff.
//When diff == 0 and both characters are letters, we simply compare the characters and move the i and j pointers to the next positions.
//Memoization (visited array) is used to prevent repeated work.

//Time complexity: O(n * m) n represent the length of string s1, and m represent the length of string s2
//Space complexity: O(n * m)

class Solution {
    private static final int DIFF_OFFSET = 1000;

    public boolean possiblyEquals(String s1, String s2) {
        boolean[][][] visited = new boolean[s1.length() + 1][s2.length() + 1][DIFF_OFFSET * 2];
        return possiblyEquals(s1.toCharArray(), s2.toCharArray(), 0, 0, 0, visited);
    }

    private boolean possiblyEquals(char[] s1, char[] s2, int i, int j, int diff, boolean[][][] visited) {
        // Base
        if (i == s1.length && j == s2.length) 
            return diff == 0;
        if (i > s1.length || j > s2.length) 
            return false;

        if (visited[i][j][diff + DIFF_OFFSET]) 
            return false;
        visited[i][j][diff + DIFF_OFFSET] = true;

        char c1 = i < s1.length ? s1[i] : Character.MIN_VALUE;
        char c2 = j < s2.length ? s2[j] : Character.MIN_VALUE;
        // 1) S1 Digit
        if (i < s1.length && Character.isDigit(c1)) {
            int num = 0;
            while (i < s1.length && Character.isDigit(s1[i])) {
                int digit = s1[i] - '0';
                num = num * 10 + digit;
                if (possiblyEquals(s1, s2, i + 1, j, diff + num, visited)) 
                    return true;
                i++;
            }
        }
        // 2) S2 Digit
        else if (Character.isDigit(c2)) {
            int num = 0;
            while (j < s2.length && Character.isDigit(s2[j])) {
                int digit = s2[j] - '0';
                num = num * 10 + digit;
                if (possiblyEquals(s1, s2, i, j + 1, diff - num, visited)) 
                    return true;
                j++;
            }
        } else {
            if (diff > 0)  // Search S2 j+1
                return possiblyEquals(s1, s2, i, j + 1, diff - 1, visited);
            if (diff < 0) // Search S1 i+1
                return possiblyEquals(s1, s2, i + 1, j, diff + 1, visited);
            // diff = 0 && chars same, search both i+1, j+1
            return c1 == c2 && possiblyEquals(s1, s2, i + 1, j + 1, 0, visited); 
        }

        return false;
    }
}
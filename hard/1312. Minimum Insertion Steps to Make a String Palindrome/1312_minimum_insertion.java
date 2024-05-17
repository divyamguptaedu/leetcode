//I used a dynamic programming approach to solve this problem. 
//I initialized a 2D array `dp` to store intermediate results and 
//converted the string `s` into a character array. 
//I defined a helper function that took the character array, starting index, ending index, and the `dp` array. 
//The function checked if the characters at the start and end were the same, 
//incrementing pointers inward if they matched. 
//If not, it calculated the minimum insertions by 
//recursively trying both possibilities—inserting at the start or at the end. 
//The result was stored in the `dp` array to avoid redundant calculations.

//Time: O(n^2)
//Space: O(n^2)
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n]; // dp to store if cases with current start and end character have been already
                                    // handled
        char[] ar = s.toCharArray();
        return helper(ar, 0, n - 1, dp);
    }

    public int helper(char[] ar, int start, int end, int[][] dp) {
        if (dp[start][end] != 0)
            return dp[start][end]; // if handled this case return val

        // iterating until to outer characters dont match
        while (ar[start] == ar[end] && start < end) {
            start++;
            end--;
        }
        // if every character in the current range match return 0
        if (start >= end)
            return 0;

        // incrementing start pointer means we have inserted character equal to char at
        // start in the position of end
        // incrementing end pointer means we have inserted character equal to char at
        // end in the position of start
        int val = Math.min(helper(ar, start + 1, end, dp), helper(ar, start, end - 1, dp));
        return dp[start][end] = val + 1; // adding 1
    }
}
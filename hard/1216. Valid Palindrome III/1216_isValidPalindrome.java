//To determine if a string s is a k-palindrome, I used dynamic programming. 
//I initialized a memoization array to keep track of the minimum deletions required to make substrings palindromic. 
//Starting from the end of the string, I iterated over each character pair (i, j). 
//If the characters at i and j matched, I set the current memo value to the previously computed value for the substring s[i+1:j-1]. 
//If they didn't match, I calculated the minimum deletions needed by either removing the character at i or j. 
//Finally, I checked if the value for the entire string was less than or equal to k.

//Time: O(n^2) n is the length of the string s
//SPace: O(n)
class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int memo[] = new int[s.length()];

        // To store the previous required values from memo.
        int temp, prev;

        // Generate all combinations of `i` and `j` in the correct order.
        for (int i = s.length() - 2; i >= 0; i--) {
            // 'prev' stores the value at memo[i+1][j-1];
            prev = 0;
            for (int j = i + 1; j < s.length(); j++) {
                // Store the value of memo[i+1][j] temporarily.
                temp = memo[j];

                // Case 1: Character at `i` equals character at `j`
                if (s.charAt(i) == s.charAt(j))
                    memo[j] = prev;

                // Case 2: Character at `i` does not equal character at `j`.
                // Either delete character at `i` or delete character at `j`
                // and try to match the two pointers using recursion.
                // We need to take the minimum of the two results and add 1
                // representing the cost of deletion.
                else

                    // memo[j] will contain the value for memo[i+1][j]
                    // memo[j-1] will contain the value for memo[i][j-1]
                    memo[j] = 1 + Math.min(memo[j], memo[j - 1]);

                // Copy the value of memo[i+1][j] to `prev`
                // For the next iteration when j=j+1
                // `prev` will hold the value memo[i+1][j-1];
                prev = temp;
            }
        }

        // Return true if the minimum cost to create a palindrome by only deleting the
        // letters
        // is less than or equal to `k`.
        return memo[s.length() - 1] <= k;
    }
};
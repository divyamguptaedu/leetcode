//I iterate through each character in the string. 
//For each character, I consider it as the center of a palindrome and expand outwards to find palindromic substrings. 
//I handle both odd-length and even-length palindromes by considering single and consecutive characters as centers. 
//For odd-length palindrome, the center is just one element, however for even, its two elements.
//I count the number of palindromes around each center and accumulate the total count. 

//Time: O(n^2)
//Space: O(1)
class Solution {
    public int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            ans += countPalindromesAroundCenter(s, i, i);

            // even-length palindromes, consecutive characters center
            ans += countPalindromesAroundCenter(s, i, i + 1);
        }

        return ans;
    }

    private int countPalindromesAroundCenter(String ss, int lo, int hi) {
        int ans = 0;

        while (lo >= 0 && hi < ss.length()) {
            if (ss.charAt(lo) != ss.charAt(hi))
                break; // the first and last characters don't match!

            // expand around the center
            lo--;
            hi++;
            ans++;
        }

        return ans;
    }
}
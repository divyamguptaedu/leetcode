// Approach: I use a dynamic programming approach to calculate the variance for every pair of characters. I maintain two 2D arrays to store the current difference and the best difference seen so far for each pair. I update these arrays while iterating through the string and track the maximum variance found.

// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    public int largestVariance(String s) {
        int maxVariance = 0;
        int[][] currentDiff = new int[26][26];
        int[][] bestDiff = new int[26][26];
        
        for (int i = 0; i < 26; i++) {
            Arrays.fill(bestDiff[i], -s.length());
        }

        for (int index = 0; index < s.length(); index++) {
            int currentChar = s.charAt(index) - 'a';
            for (int otherChar = 0; otherChar < 26; otherChar++) {
                if (otherChar == currentChar) continue;
                ++currentDiff[currentChar][otherChar];
                ++bestDiff[currentChar][otherChar];
                bestDiff[otherChar][currentChar] = --currentDiff[otherChar][currentChar];
                currentDiff[otherChar][currentChar] = Math.max(currentDiff[otherChar][currentChar], 0);
                maxVariance = Math.max(maxVariance, Math.max(bestDiff[currentChar][otherChar], bestDiff[otherChar][currentChar]));
            }
        }
        return maxVariance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "aababbb";
        String s2 = "abcde";

        System.out.println("Test case 1: " + solution.largestVariance(s1)); // Expected output: 3
        System.out.println("Test case 2: " + solution.largestVariance(s2)); // Expected output: 1
    }
}
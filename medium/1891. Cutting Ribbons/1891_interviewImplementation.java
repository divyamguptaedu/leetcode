// You are given an integer array ribbons, where ribbons[i] represents the length of the ith ribbon, and an integer k. You may cut any of the ribbons into any number of segments of positive integer lengths, or perform no cuts at all.
// For example, if you have a ribbon of length 4, you can:
// Keep the ribbon of length 4,
// Cut it into one ribbon of length 3 and one ribbon of length 1,
// Cut it into two ribbons of length 2,
// Cut it into one ribbon of length 2 and two ribbons of length 1, or
// Cut it into four ribbons of length 1.
// Your goal is to obtain k ribbons of all the same positive integer length. You are allowed to throw away any excess ribbon as a result of cutting.
// Return the maximum possible positive integer length that you can obtain k ribbons of, or 0 if you cannot obtain k ribbons of the same length.

import java.util.*;

class Solution {
    public int maxLength(int[] ribbons, int k) {
        int l = 1;
        int r = (int) 1e5 + 1;
        
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            
            if (!isCutPossible(ribbons, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l - 1;
    }

    public boolean isCutPossible(int[] ribbons, int length, int k) {
        int count = 0;
        
        for (int ribbon : ribbons) {
            count += (ribbon / length);
        }
        
        return count >= k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage and testing
        int[] ribbons1 = {5, 9, 7}; 
        int k1 = 3;
        System.out.println("Maximum length to obtain " + k1 + " ribbons: " + solution.maxLength(ribbons1, k1)); // Output: 5
        
        int[] ribbons2 = {7, 7, 7};
        int k2 = 10;
        System.out.println("Maximum length to obtain " + k2 + " ribbons: " + solution.maxLength(ribbons2, k2)); // Output: 3
        
        int[] ribbons3 = {1, 2, 3, 4, 5};
        int k3 = 10;
        System.out.println("Maximum length to obtain " + k3 + " ribbons: " + solution.maxLength(ribbons3, k3)); // Output: 0
    }
}
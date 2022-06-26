"""
Performance:
Runtime: 4 ms, faster than 97.54% of Java online submissions for Permutation in String.
Memory Usage: 43.8 MB, less than 33.78% of Java online submissions for Permutation in String.
"""

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Size = s1.length();
        int s2Size = s2.length();
        if (s1Size > s2Size) {
            return false;
        }
        int[] tempOne = new int[26];
        int[] tempTwo = new int[26];
        for (char ch:s1.toCharArray()) {
            tempOne[ch - 'a']++;
        }
        for (int i = 0; i < s1Size; i++) {
            tempTwo[s2.charAt(i) - 'a']++;
        }
        for (int i = 0, j = i + s1Size - 1 ; j < s2Size ; j++,i++) { 
            if (i > 0) {
                tempTwo[s2.charAt(i - 1) - 'a']--;
                tempTwo[s2.charAt(j) - 'a']++;
            }
            
            if (helper(tempOne, tempTwo)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean helper(int[]a, int[]b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += palindromeCount(s, i, i);
            count += palindromeCount(s, i, i + 1);
        }
        return count;
    }

    private int palindromeCount(String s, int left, int right) {
        int numberOfPalindromes = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            numberOfPalindromes++;
            left--;
            right++;
        }
        return numberOfPalindromes;
    }
}
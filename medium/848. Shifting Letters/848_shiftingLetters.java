"
Performance:
Runtime: 11 ms, faster than 92.36% of Java online submissions for Shifting Letters.
Memory Usage: 51 MB, less than 93.79% of Java online submissions for Shifting Letters.
"

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
		for (int i = shifts.length - 1; i > 0; i--) {
            shifts[i - 1] += shifts[i];
            shifts[i - 1] %= 26;
        }
        char[] result = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            result[i] = (char) ('a' + (result[i] - 'a' + shifts[i]) % 26);
        }
        return String.valueOf(result);
    }
}
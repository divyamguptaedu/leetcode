class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sLetters = new int[26];
        int[] tLetters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sLetters[s.charAt(i) - 'a']++;
            tLetters[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sLetters[i] != tLetters[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "anagram";
        String t1 = "nagaram";
        boolean result1 = solution.isAnagram(s1, t1);
        System.out.println("Is '" + t1 + "' an anagram of '" + s1 + "'? " + result1);

        // Test Case 2
        String s2 = "rat";
        String t2 = "car";
        boolean result2 = solution.isAnagram(s2, t2);
        System.out.println("Is '" + t2 + "' an anagram of '" + s2 + "'? " + result2);
    }
}

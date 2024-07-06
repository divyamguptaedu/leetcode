/*
Count Character Frequencies:
First, you count the frequency of each character in the string s using an array charCount of size 26 (for each letter in the English alphabet).
For each character in the string s, increment its corresponding count in the charCount array.

Filter Valid Characters:
Create a list validChars that will hold characters that appear at least k times in the string s. 
This is because only such characters can possibly be part of a subsequence that repeats k times.

Breadth-First Search (BFS) for Subsequence:
Use a queue to perform BFS. Start with an empty string and try to extend it by adding characters from the validChars list.
For each string generated by adding a character from validChars, check if it can be a subsequence repeated k times in s using the helper function isKSubsequence.
If it is a valid subsequence, add it to the queue for further exploration and update the longestSubsequence if it is longer or lexicographically larger than the current longest.

Helper Function isKSubsequence:
This function checks if a given subsequence can be repeated k times in the string s.
It iterates through the string s and tries to match the characters of the subsequence repeatedly. It keeps count of how many times the entire subsequence is found in s.

Return the Result:
After exploring all possible subsequences, the longest one that is repeated k times is stored in longestSubsequence, which is then returned.

Time Complexity: O(m^L⋅n), where m is the number of valid characters and L is the length of the longest subsequence.
Space Complexity: O(m^L).
*/
class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        String longestSubsequence = "";

        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charCount[ch - 'a']++;
        }

        ArrayList<Character> validChars = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (charCount[i] >= k) {
                validChars.add((char) ('a' + i));
            }
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("");
        while (!queue.isEmpty()) {
            String current = queue.removeFirst();
            for (char ch : validChars) {
                String next = current + ch;
                if (isKSubsequence(s, next, k)) {
                    queue.addLast(next);
                    if (next.length() > longestSubsequence.length() ||
                        (next.length() == longestSubsequence.length() && next.compareTo(longestSubsequence) > 0)) {
                        longestSubsequence = next;
                    }
                }
            }
        }

        return longestSubsequence;
    }

    private boolean isKSubsequence(String s, String subsequence, int k) {
        int j = 0;
        int repetitions = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == subsequence.charAt(j)) {
                j++;
                if (j == subsequence.length()) {
                    repetitions++;
                    j = 0;
                    if (repetitions == k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
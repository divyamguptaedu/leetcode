//I approached the problem of finding the longest subsequence repeated k times in string s using a 
//breadth-first search (BFS) strategy combined with a backtracking method to validate potential subsequences. 
//First, I counted character frequencies in the string s and filtered out characters 
//that appear at least k times. Using BFS with a queue, I constructed potential subsequences by appending 
//valid characters. For each constructed subsequence, I validated if it could be repeated k 
//times within s using a helper function isKSub. This function checks if the subsequence appears k times 
//in order within s. The BFS ensures that longer valid subsequences are explored first, 
//and the lexicographically largest valid subsequence is retained.
//Time: 26*n*2^l wjere n is len of s and l is len of longest valid subseq found
//Space: n
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

    boolean isKSubsequence(String s, String subsequence, int k) {
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
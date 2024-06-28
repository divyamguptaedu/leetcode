//I approached the problem of finding common characters across all strings in the array by using two arrays: one to track the minimum counts of characters that appear in all words (commonCharacterCounts) and another to temporarily count characters in each word (currentCharacterCounts). Initially, I populated commonCharacterCounts with counts from the first word. Then, for each subsequent word, I updated currentCharacterCounts and adjusted commonCharacterCounts to maintain the minimum counts of characters. Finally, I converted these counts back into characters and collected them into a result list.
//Time: nk where n is num strings in words and k is avg len of strings in words.
//Space: constant
class Solution {

    public List<String> commonChars(String[] words) {
        int wordsSize = words.length;
        int[] commonCharacterCounts = new int[26];
        int[] currentCharacterCounts = new int[26];
        List<String> result = new ArrayList<>();

        // Initialize commonCharacterCounts with the characters from the first
        // word
        for (char ch : words[0].toCharArray()) {
            commonCharacterCounts[ch - 'a']++;
        }

        for (int i = 1; i < wordsSize; i++) {
            Arrays.fill(currentCharacterCounts, 0);

            // Count characters in the current word
            for (char ch : words[i].toCharArray()) {
                currentCharacterCounts[ch - 'a']++;
            }

            // Update the common character counts to keep the minimum counts
            for (int letter = 0; letter < 26; letter++) {
                commonCharacterCounts[letter] = Math.min(
                        commonCharacterCounts[letter],
                        currentCharacterCounts[letter]);
            }
        }

        // Collect the common characters based on the final counts
        for (int letter = 0; letter < 26; letter++) {
            for (int commonCount = 0; commonCount < commonCharacterCounts[letter]; commonCount++) {
                result.add(String.valueOf((char) (letter + 'a')));
            }
        }

        return result;
    }
}
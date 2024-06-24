//I created a map to store all generic transformations of words in the word list. 
//Each key in this map is a generic word formed by replacing one letter of a word with *, 
//and the value is a list of all words that can be formed with that generic pattern. 
//Using BFS, I started from the beginWord and tried all possible one-letter transformations, 
//checking if the endWord is reached. If a word transformation is valid and not visited yet, 
//it is added to the queue for further exploration.
//Time: m^2 * n where m is the len of each word and n is total number of words
//Space: m^2 * n
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // All words are of the same length
        int wordLength = beginWord.length();

        // Dictionary to hold all possible intermediate transformations
        Map<String, List<String>> allComboDict = new HashMap<>();

        // Preprocess the word list into the dictionary
        for (String word : wordList) {
            for (int i = 0; i < wordLength; i++) {
                // Create a new generic word by replacing one character with '*'
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLength);
                // Get the list of transformations for this generic word
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        }

        // Queue for BFS: holds pairs of (current word, level of transformation)
        Queue<Pair<String, Integer>> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Pair(beginWord, 1));

        // Map to track visited words to prevent cycles
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!bfsQueue.isEmpty()) {
            // Get the next word and its level from the queue
            Pair<String, Integer> currentPair = bfsQueue.remove();
            String currentWord = currentPair.getKey();
            int currentLevel = currentPair.getValue();

            // Try all possible one-letter transformations
            for (int i = 0; i < wordLength; i++) {
                // Create the intermediate word
                String newWord = currentWord.substring(0, i) + '*' + currentWord.substring(i + 1, wordLength);

                // Check all words that can be formed with this intermediate word
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If the end word is found, return the current level + 1
                    if (adjacentWord.equals(endWord)) {
                        return currentLevel + 1;
                    }
                    // If the word has not been visited, mark it visited and add to the queue
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        bfsQueue.add(new Pair(adjacentWord, currentLevel + 1));
                    }
                }
            }
        }

        // If the end word is not found, return 0
        return 0;
    }
}
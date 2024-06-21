//I used Breadth-First Search (BFS) to find the shortest transformation sequence. 
//I first built a map of patterns to words by replacing each letter of each word with an asterisk, 
//creating a wildcard pattern. This helped in quickly finding adjacent words that differ by one letter. 
//I then initiated a BFS from the beginWord, using a queue to explore each word level by level. 
//If the endWord was found, I returned the current level count. 
//I kept track of visited words to avoid cycles. If the endWord was not found, I returned 0.

//Time: nm^2 where n is the #words and m is len of the words.
//Space: nm^2

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Return 0 if endWord is not in wordList
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Map to store pattern to list of words
        Map<String, List<String>> patternToWords = new HashMap<>();
        wordList.add(beginWord);

        // Build the pattern map
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternToWords.putIfAbsent(pattern, new ArrayList<>());
                patternToWords.get(pattern).add(word);
            }
        }

        // BFS initialization
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int steps = 1;

        // BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                // Check if we reached the endWord
                if (currentWord.equals(endWord)) {
                    return steps;
                }

                // Explore all patterns of the current word
                for (int j = 0; j < currentWord.length(); j++) {
                    String pattern = currentWord.substring(0, j) + "*" + currentWord.substring(j + 1);
                    for (String neighbor : patternToWords.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}
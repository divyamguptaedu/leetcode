class Solution {
    HashMap<String, Integer> wordMap = new HashMap<>();
    Set<String> resultList = new HashSet<>();
    int maxLength = -1;

    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], 1);
            maxLength = Math.max(maxLength, words[i].length());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                checkWord(i, j, "", board, visited);
            }
        }
        return new ArrayList<>(resultList);
    }

    private void checkWord(int i, int j, String currentWord, char[][] board, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == true || currentWord.length() >= maxLength) {
            return;
        }
        visited[i][j] = true;
        currentWord += board[i][j];
        if (wordMap.containsKey(currentWord)) {
            resultList.add(currentWord);
        }

        checkWord(i - 1, j, currentWord, board, visited);
        checkWord(i + 1, j, currentWord, board, visited);
        checkWord(i, j - 1, currentWord, board, visited);
        checkWord(i, j + 1, currentWord, board, visited);

        currentWord = currentWord.substring(0, currentWord.length() - 1);
        visited[i][j] = false;
    }
}
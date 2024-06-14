//I constructed a reverse graph using BFS starting from the beginWord. 
//This graph helped to identify the shortest paths to the endWord. 
//Once the BFS found all paths to the endWord, I used DFS to traverse the
//reverse graph from endWord to beginWord to gather all valid transformation sequences. 
//The BFS ensured that the paths were the shortest, and the DFS allowed for 
//backtracking to collect all possible paths.

/*
Detailed Processing of the Input Example
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]

BFS Construction
Start with beginWord = "hit".
Explore possible transformations:
hit -> hot (valid), update reverse graph: hot -> {hit}
Queue: ["hot"], Word Set: ["dot","dog","lot","log","cog"]
Next layer with hot:
hot -> dot (valid), update reverse graph: dot -> {hot}
hot -> lot (valid), update reverse graph: lot -> {hot}
Queue: ["dot", "lot"], Word Set: ["dog","log","cog"]
Next layer with dot and lot:
dot -> dog (valid), update reverse graph: dog -> {dot}
lot -> log (valid), update reverse graph: log -> {lot}
Queue: ["dog", "log"], Word Set: ["cog"]
Next layer with dog and log:
dog -> cog (valid), update reverse graph: cog -> {dog}
log -> cog (valid), update reverse graph: cog -> {log}
Queue: ["cog"], Word Set: []
endWord found, stop BFS.
DFS Path Construction
Start DFS from cog:
Path: ["cog"]
Explore cog -> dog and cog -> log
For cog -> dog:
Path: ["cog", "dog"]
Explore dog -> dot
Path: ["cog", "dog", "dot"]
Explore dot -> hot
Path: ["cog", "dog", "dot", "hot"]
Explore hot -> hit
Path: ["cog", "dog", "dot", "hot", "hit"]
Reverse and add to ans: ["hit", "hot", "dot", "dog", "cog"]
For cog -> log:
Path: ["cog", "log"]
Explore log -> lot
Path: ["cog", "log", "lot"]
Explore lot -> hot
Path: ["cog", "log", "lot", "hot"]
Explore hot -> hit
Path: ["cog", "log", "lot", "hot", "hit"]
Reverse and add to ans: ["hit", "hot", "lot", "log", "cog"]
Final Output:
[
  ["hit", "hot", "dot", "dog", "cog"],
  ["hit", "hot", "lot", "log", "cog"]
]
*/
//Time: NM^2 where N is the #words, and M is the max len of a word.
//Space: NM
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>(); 
        Map<String, Set<String>> reverse = new HashMap<>(); // reverse graph start from endWord
        Set<String> wordSet = new HashSet<>(wordList); // remove the duplicate words
        wordSet.remove(beginWord); // remove the first word to avoid cycle path
        Queue<String> queue = new LinkedList<>(); // store current layer nodes
        queue.add(beginWord); // first layer has only beginWord
        Set<String> nextLevel = new HashSet<>(); // store nextLayer nodes
        boolean findEnd = false; // find endWord flag
        while (!queue.isEmpty()) { // traverse current layer nodes
            String word = queue.remove();
            for (String next : wordSet) {
                if (isLadder(word, next)) { // is ladder words
					// construct the reverse graph from endWord
                    Set<String> reverseLadders = reverse.computeIfAbsent(next, k -> new HashSet<>());
                    reverseLadders.add(word); 
                    if (endWord.equals(next)) {
                        findEnd = true;
                    }
                    nextLevel.add(next); // store next layer nodes
                }
            }
            if (queue.isEmpty()) { // when current layer is all visited
                if (findEnd) break; // if find the endWord, then break the while loop
                queue.addAll(nextLevel); // add next layer nodes to queue
                wordSet.removeAll(nextLevel); // remove all next layer nodes in wordSet
                nextLevel.clear();
            }
        }
        if (!findEnd) return ans; // if can't reach endWord from startWord, then return ans.
        Set<String> path = new LinkedHashSet<>();
        path.add(endWord);
		// traverse reverse graph from endWord to beginWord
        findPath(endWord, beginWord, reverse, ans, path); 
        return ans;
    }


    private void findPath(String endWord, String beginWord, Map<String, Set<String>> graph,
                                 List<List<String>> ans, Set<String> path) {
        Set<String> next = graph.get(endWord);
        if (next == null) return;
        for (String word : next) {
            path.add(word);
            if (beginWord.equals(word)) {
                List<String> shortestPath = new ArrayList<>(path);
                Collections.reverse(shortestPath); // reverse words in shortest path
                ans.add(shortestPath); // add the shortest path to ans.
            } else {
                findPath(word, beginWord, graph, ans, path);
            }
            path.remove(word);
        }
    }

    private boolean isLadder(String s, String t) {
        if (s.length() != t.length()) return false;
        int diffCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) diffCount++;
            if (diffCount > 1) return false;
        }
        return diffCount == 1;
    }
}
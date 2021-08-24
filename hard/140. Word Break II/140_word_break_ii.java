"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Word Break II.
Memory Usage: 37.6 MB, less than 54.39% of Java online submissions for Word Break II.
"

class Solution {
    public List<String> wordBreak(String wordToBreak, List<String> wordDict) {        
        return helper(wordToBreak, wordDict, new HashMap<>());
    }
    
    public List<String> helper(String wordToBreak, List<String> wordDict, Map<String, List<String>> wordBrokenDict){
        if (wordBrokenDict.containsKey(wordToBreak)) {
            return wordBrokenDict.get(wordToBreak);
        }
        
        List<String> solutions = new ArrayList<>();
        for (String word: wordDict) {
            if (!wordToBreak.startsWith(word)) {
                continue;
            }
            
            if (wordToBreak.length() == word.length()) {
                solutions.add(word);
                continue;
            }
            
            List<String> subSolutions = helper(wordToBreak.substring(word.length()), wordDict, wordBrokenDict);
            for(String subSolution: subSolutions) {
                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append(word).append(' ').append(subSolution);
                solutions.add(strBuilder.toString());
            }
        }
        
        wordBrokenDict.put(wordToBreak, solutions);
        return solutions;
    }
}
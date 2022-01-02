"""
Performance: 
Runtime: 228 ms, faster than 26.84% of Java online submissions for Substring with Concatenation of All Words.
Memory Usage: 40 MB, less than 37.17% of Java online submissions for Substring with Concatenation of All Words.
"""

class Solution {
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new ArrayList<>();
        int length = words[0].length();
        Map<String,Integer> mapWords = helper(words);
        
        for (int i = 0 ; i + (length * words.length) <= s.length(); i++) {
            if (mapWords.equals(helper(s.substring(i, i + (length * words.length)), (length)))) {
                output.add(i);
            }
        }
        return output;
    }

    public Map<String,Integer> helper(String s , int t){
        Map<String,Integer> map = new HashMap<>();
        String currentWord;
        for (int i = 0; i + t <= s.length() ; i += t) { 
            currentWord = s.substring(i, i + t);
            if (map.containsKey(currentWord)) {
                map.put(currentWord, map.get(currentWord) + 1);
            } else {
                map.put(currentWord, 1);
            }
        }
        return map;
    }

    public <T> Map<T, Integer> helper(T[] words){
        Map<T, Integer> map = new HashMap<>();
        for (T word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

}
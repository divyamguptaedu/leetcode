"
Performance:
Runtime: 961 ms, faster than 25.82% of Java online submissions for Concatenated Words.
Memory Usage: 45.2 MB, less than 47.51% of Java online submissions for Concatenated Words.
"

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words){
            set.add(word);
        }
        for (String word: words){
            set.remove(word);
            if (helper(word, set)) {
                result.add(word);
            }
            set.add(word);
        }
        return result;
    }
    
    private boolean helper(String s, Set<String> set){
        int size = s.length();
        if (size == 0 || set.size() == 0)
            return false;
        boolean[] store = new boolean[size+1];
        store[0] = true;
        for (int i = 1; i <= size; ++i){
            for (int j = 0; j < i; ++j){
                if (store[j] && set.contains(s.substring(j, i))){
                    store[i] = true;
                    break;
                }
            }
        }
        return store[size];
    }
}
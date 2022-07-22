"
Performance:
Runtime: 32 ms, faster than 67.36% of Java online submissions for Word Subsets.
Memory Usage: 93.1 MB, less than 28.51% of Java online submissions for Word Subsets.
"

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        int[] array = new int[26];
        for (String word : B) {
            int[] temp = new int[26];
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
                array[ch - 'a'] = Math.max(array[ch - 'a'], temp[ch - 'a']);
            }
        }
        for (String word : A) {
            int[] source = new int[26];
            for (char ch : word.toCharArray()) {
                source[ch - 'a']++;
            }
            if (subset(source,array)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean subset(int[] parent,int[] child){
        for (int i = 0; i < 26; i++) {
            if (parent[i] < child[i]) {
                return false;
            }
        }
        return true;
    }
}

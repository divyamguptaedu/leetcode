"
Performance:
Runtime: 45 ms, faster than 84.46% of Java online submissions for Short Encoding of Words.
Memory Usage: 53.7 MB, less than 69.26% of Java online submissions for Short Encoding of Words.

"

class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> first = new HashSet<>();
        Set<String> second = new HashSet<>();
        for (String s : words) {
            first.add(s);
            second.add(s);
        }
        for (String word : first) {
            for (int i = 0; i < word.length(); i++) {
                String substring = word.substring(i + 1);
                if (second.contains(substring)) {
                    second.remove(substring);
                }
            }
        }
        int result = 0; 
        for (String word : second) {
            result += word.length();
        }
        
        return result + second.size();
        
    }
}
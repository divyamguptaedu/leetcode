"
Performance:
Runtime: 1 ms, faster than 84.54% of Java online submissions for Custom Sort String.
Memory Usage: 42 MB, less than 62.18% of Java online submissions for Custom Sort String.
"

class Solution {
    public String customSortString(String order, String s) {
        int[] frequencyList = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            frequencyList[letter - 'a']++;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {            
            char letter = order.charAt(i);
            int frequencyCount = frequencyList[letter - 'a'];
            while (frequencyCount > 0) {
                result.append(letter);
                frequencyCount--;
            }
            frequencyList[letter - 'a'] = 0;
        }
        
        for (int i = 0; i < 26; i++) {
            int frequencyCount = frequencyList[i];
            while (frequencyCount > 0) {
                result.append((char) (i + 'a'));
                frequencyCount--;
            }
        }
        
        return result.toString();
    }
}
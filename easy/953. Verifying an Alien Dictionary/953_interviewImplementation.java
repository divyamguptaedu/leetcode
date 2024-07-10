// In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
// Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            int len = Math.min(prev.length(), curr.length());
            int j = 0;
            
            // Compare characters until we find a difference or reach the end of one of the words
            while (j < len && prev.charAt(j) == curr.charAt(j)) {
                j++;
            }
            
            // If we reached the end of one word but the other is longer, it's not sorted
            if (j < len && order.indexOf(prev.charAt(j)) > order.indexOf(curr.charAt(j))) {
                return false;
            }
            
            // If the prefix is the same but prev is longer than curr, it's not sorted
            if (j == len && prev.length() > curr.length()) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage and testing
        String[] words1 = {"hello", "leetcode"};
        String order1 = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println("Are words1 sorted in alien language order? " + solution.isAlienSorted(words1, order1)); // Output: true
        
        String[] words2 = {"word", "world", "row"};
        String order2 = "worldabcefghijkmnpqstuvxyz";
        System.out.println("Are words2 sorted in alien language order? " + solution.isAlienSorted(words2, order2)); // Output: false
        
        String[] words3 = {"apple", "app"};
        String order3 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Are words3 sorted in alien language order? " + solution.isAlienSorted(words3, order3)); // Output: false
    }
}
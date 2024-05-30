//I created a frequency table for the characters in string 's'. 
//Then, I iterated through the 'order' string and appended characters according to their frequency in 's', 
//ensuring the custom order. After processing 'order', 
//I appended any remaining characters from 's' that were not in 'order'. 
//Finally, I returned the constructed string.

//Time: O(n+k) where n is len of string s and k is the len of order.
//Space: O(n)
class Solution {
    public String customSortString(String order, String s) {
        // Create a frequency table
        Map<Character, Integer> freq = new HashMap<>();

        // Initialize frequencies of letters
        // freq[c] = frequency of char c in s
        int N = s.length();
        for (int i = 0; i < N; i++) {
            char letter = s.charAt(i);
            freq.put(letter, freq.getOrDefault(letter, 0) + 1);
        }

        // Iterate order string to append to result
        int K = order.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < K; i++) {
            char letter = order.charAt(i);
            while (freq.getOrDefault(letter, 0) > 0) {
                result.append(letter);
                freq.put(letter, freq.get(letter) - 1);
            }
        }

        // Iterate through freq and append remaining letters
        // This is necessary because some letters may not appear in `order`
        for (char letter : freq.keySet()) {
            int count = freq.get(letter);
            while (count > 0) {
                result.append(letter);
                count--;
            }
        }

        // Return the result
        return result.toString();
    }
}
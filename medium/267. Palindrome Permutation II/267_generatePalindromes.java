//I used backtracking to generate all palindromic permutations of the given string. 
//Firstly, I calculated the frequency of each character. If the count of characters with odd frequencies is greater than 1, 
//no palindromic permutation is possible. 
//Then, I divided the string into two halves: one for the left side of the palindrome and one for the right. 
//The character with an odd frequency, if present, becomes the middle character. 
//During backtracking, I iterated through the characters, appending them to the left side and recursively generating permutations. 
//Once the left side is complete, I added the middle character (if any) and the reverse of the left side to form a palindrome.

//Time: O(n!) where n is the length of the input string
//Space: O(n!)
class Solution {
    private List<String> list = new ArrayList<>();

    public List<String> generatePalindromes(String s) {
        int numOdds = 0; // Number of characters with odd count
        int[] map = new int[256]; // Map from character to its frequency
        
        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            map[c]++;
            numOdds = (map[c] & 1) == 1 ? numOdds + 1 : numOdds - 1; // Update numOdds based on parity
        }
        
        // If more than one character has odd frequency, no palindrome can be formed
        if (numOdds > 1)
            return list;

        String mid = "";
        int length = 0;
        
        // Divide the string into two halves
        for (int i = 0; i < 256; i++) {
            if (map[i] > 0) {
                if ((map[i] & 1) == 1) { // Character with odd count will be in the middle
                    mid = "" + (char) i;
                    map[i]--;
                }
                map[i] /= 2; // Halve the frequency since we only generate half string
                length += map[i]; // Update the length of half string
            }
        }
        
        // Generate palindromic permutations recursively
        generatePalindromesHelper(map, length, "", mid);
        return list;
    }

    // Backtracking function to generate palindromic permutations
    private void generatePalindromesHelper(int[] map, int length, String s, String mid) {
        // If the left half is complete, add mid and reverse of s to form palindrome
        if (s.length() == length) {
            StringBuilder reverse = new StringBuilder(s).reverse(); // Second half
            list.add(s + mid + reverse);
            return;
        }
        
        // Iterate through characters and append them to the left side
        for (int i = 0; i < 256; i++) {
            if (map[i] > 0) {
                map[i]--;
                generatePalindromesHelper(map, length, s + (char) i, mid); // Recursive call
                map[i]++; // Backtrack
            }
        }
    }
}

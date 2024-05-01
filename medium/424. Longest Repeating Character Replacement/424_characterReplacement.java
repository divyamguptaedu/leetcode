//We use a sliding window approach to solve this question. We set the start and end to 0, initialize a frequency map to have the frequency of 
//each char in the window, and keep track of the maximum frequency in the map, and the longestSubstringLength seen till now. 
//We don't need to actually change the letters to something else and calculate the length, we can just see if 
//if the length of the window - the maximum frequency of an element in the window is less than or equal to K. If yes, its valid and we can use that length.
//So, we will iterate over the string, keep on moving the end pointer, increasing the size of the window till its valid.
//If it becomes invalid, we move the start pointer.
//When we move the start pointer we dont need to recalculate the maxFrequency because it only matters if the frequency is incresing.

//Time: O(n)
//Space: O(m) where m is 26.
class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int[] frequencyMap = new int[26];
        int maxFrequency = 0;
        int longestSubstringLength = 0;

        for (int end = 0; end < s.length(); end++) {
            // if 'A' is 0, then what is the relative order
            // or offset of the current character entering the window
            // 0 is 'A', 1 is 'B' and so on
            int currentChar = s.charAt(end) - 'A';

            frequencyMap[currentChar] += 1;

            // the maximum frequency we have seen in any window yet
            maxFrequency = Math.max(maxFrequency, frequencyMap[currentChar]);

            // move the start pointer towards right if the current
            // window is invalid
            Boolean isValid = (end + 1 - start - maxFrequency <= k);
            if (!isValid) {
                // offset of the character moving out of the window
                int outgoingChar = s.charAt(start) - 'A';

                // decrease its frequency
                frequencyMap[outgoingChar] -= 1;

                // move the start pointer forward
                start += 1;
            }

            // the window is valid at this point, note down the length
            // size of the window never decreases
            longestSubstringLength = end + 1 - start;
        }

        return longestSubstringLength;
    }
}
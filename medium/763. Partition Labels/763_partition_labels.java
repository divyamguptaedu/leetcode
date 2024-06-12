//I calculated the last occurrence of each character in the string and
//stored it in an array. Then, I used two pointers to track the current
//partition's start and end. As I iterated through the string, 
// updated the end pointer to the farthest last occurrence of the current character. 
//When I reached the end pointer, I added the length of the current partition to the 
//result list and moved the start pointer to the next character.

//Time: n
//Space: constant
class Solution {
    public List<Integer> partitionLabels(String s) {
        // Array to store the last occurrence of each character
        int[] lastOccurrence = new int[26];
        // Populate the array with the last occurrence index of each character in the string
        for (int i = 0; i < s.length(); ++i)
            lastOccurrence[s.charAt(i) - 'a'] = i;
        
        int maxLastIndex = 0, partitionStartIndex = 0;
        List<Integer> partitionSizes = new ArrayList<>();
        
        for (int i = 0; i < s.length(); ++i) {
            // Update the maximum last occurrence index seen so far
            maxLastIndex = Math.max(maxLastIndex, lastOccurrence[s.charAt(i) - 'a']);
            // When the current index matches the maximum last index, a partition ends
            if (i == maxLastIndex) {
                // Add the size of the current partition to the result list
                partitionSizes.add(i - partitionStartIndex + 1);
                // Update the start index for the next partition
                partitionStartIndex = i + 1;
            }
        }
        return partitionSizes;
    }
}
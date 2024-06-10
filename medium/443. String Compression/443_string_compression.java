//I iterated through the input array, identifying consecutive repeating characters
//and their lengths. For each group, I stored the character followed by its count in
//the same array, adhering to the compression rules.
//Utilizing two pointers, I ensured efficient traversal through the array without
//additional space. My logic dynamically updates the array in-place,
//minimizing auxiliary space usage.

//Time: n
//Space: constant
class Solution {
    public int compress(char[] chars) {
        int i = 0; // Initialize pointer i to traverse the input array
        int res = 0; // Initialize the result pointer to track the current index in the compressed array
        while (i < chars.length) { // Iterate through the input array
            int groupLength = 1; // Initialize the length of the current character group
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                // Increment groupLength for consecutive repeating characters
                groupLength++;
            }
            chars[res++] = chars[i]; // Store the current character in the compressed array
            if (groupLength > 1) { // If groupLength is greater than 1, indicating repeated characters
                // Convert groupLength to a character array and store each digit in the compressed array
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength; // Move the pointer to the next group of characters
        }
        return res; // Return the length of the compressed array
    }
}
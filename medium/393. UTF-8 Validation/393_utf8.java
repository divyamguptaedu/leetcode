//I iterated through the data array to validate UTF-8 encoding. 
//For each byte, I determined if it started a new character or continued an existing one. 
//If starting a new character, I counted leading 1 bits to identify its length. 
//For continuation bytes, I checked if they began with '10'. 
//I maintained a counter for the expected continuation bytes and ensured it matched the 
//required count by the end. This approach validated each byte according to UTF-8 rules.

//Time: O(n)
//Space: O(1)

class Solution {
    public boolean validUtf8(int[] data) {
        // Number of bytes in the current UTF-8 character that need processing
        int numberOfBytesToProcess = 0;
        // Masks to check the two most significant bits in a byte.
        int mask1 = 1 << 7; // 10000000
        int mask2 = 1 << 6; // 01000000
        
        // Iterate through each integer in the data array
        for (int i = 0; i < data.length; i++) {
            // If no bytes need processing, determine the type of the new character
            if (numberOfBytesToProcess == 0) {
                int mask = 1 << 7;
                // Count the number of leading 1s to determine the number of bytes in the character
                while ((mask & data[i]) != 0) {
                    numberOfBytesToProcess += 1;
                    mask = mask >> 1;
                }
                
                // For 1-byte characters, no leading 1s are expected
                if (numberOfBytesToProcess == 0) {
                    continue;
                }
                // The number of bytes must be between 2 and 4
                if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
                    return false;
                }
            } else {
                // For continuation bytes, the most significant bit must be 1 and the second most significant bit must be 0
                if (!((data[i] & mask1) != 0 && (mask2 & data[i]) == 0)) {
                    return false;
                }
            }
            // Decrement the number of bytes left to process
            numberOfBytesToProcess -= 1;
        }
        
        // Ensure all characters have been completely processed
        return numberOfBytesToProcess == 0;
    }
}
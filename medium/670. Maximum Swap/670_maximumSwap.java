//I iterated through the digits of the number from right to left, 
//keeping track of the highest digit encountered and its position. 
//If I found a smaller digit before a larger one, I calculated the difference this swap would make 
//and updated the potential maximum gain. The variable delta stored the net effect of the best swap. 
//Finally, I added delta to the original number to obtain the maximum possible value after at most one swap.

//Time: O(d) where d is the #digits in the number
//Space: O(1)
class Solution {
    public int maximumSwap(int num) {
        int x = num; // Copy of the original number
        int delta = 0; // Initialize delta to store the maximum gain from a swap
        int hi = x % 10; // Start with the least significant digit as the highest digit encountered
        int multiple = 1; // Used to keep track of the current place value (units, tens, etc.)
        int prev = 1; // Used to store the place value of the highest digit encountered
        x /= 10; // Remove the least significant digit
        
        // Iterate through the digits from right to left
        while (x > 0) {
            multiple *= 10; // Update the place value
            int currentDigit = x % 10; // Current digit under consideration
            
            // If the current digit is greater than the highest digit encountered
            if (currentDigit > hi) {
                hi = currentDigit; // Update the highest digit
                prev = multiple; // Update the place value of the highest digit
            } 
            // If the current digit is less than the highest digit encountered
            else if (currentDigit < hi) {
                // Calculate the potential gain from swapping current digit with highest digit
                delta = (hi - currentDigit) * multiple - (hi - currentDigit) * prev;
            }
            x /= 10; // Move to the next digit
        }
        
        // Return the original number plus the maximum gain from a single swap
        return num + delta;
    }
}
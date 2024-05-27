//I iteratively reverse the given integer by continuously dividing it by 10 to extract each digit and 
//appending them in reverse order. I use a long variable to accommodate the possibility of integer overflow during reversal. 
//After reversal, I check if the reversed integer exceeds the 32-bit signed integer range. 
//If it does, I return 0; otherwise, I return the reversed integer. 
//The approach ensures efficient reversal by processing each digit of the input integer. 

//Time Complexity: O(log n)
//Space Complexity: O(1)
class Solution {
    public int reverse(int x) {
        long reverse = 0; // Initialize a long variable to store the reversed integer
        while (x != 0) { // Iterate until the input integer becomes 0
            reverse = (reverse * 10) + (x % 10); // Extract the last digit of x and append it to reverse
            x = x / 10; // Remove the last digit from x
        }
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) { // Check for integer overflow
            return 0; // If overflow occurs, return 0
        }
        return (int) reverse; // Return the reversed integer
    }
}

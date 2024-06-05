//I iterated through the string, counting the opening and closing brackets. 
//Each time I encountered a closing bracket, I checked if there was an unmatched
//opening bracket to pair it with. If there was, I paired them; otherwise, I counted it as 
//unbalanced. The number of swaps needed to balance the string is half the number of unbalanced
//closing brackets, rounded up. This is because each swap can fix two unbalanced brackets.

//Time: n
//Space: constant

class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int close = 0;
        int unbalanced = 0;
        
        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                // Increment open counter for '['
                open++;
            } else {
                // If there is an unmatched opening bracket, pair it with current closing bracket
                if (open > close) {
                    close++;
                } else {
                    // Count unbalanced closing bracket
                    unbalanced++;
                }
            }
        }
        
        // Calculate and return minimum number of swaps
        return (unbalanced + 1) / 2;
    }
}
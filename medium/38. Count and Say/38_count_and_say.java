//I iterated through each sequence up to the nth element, 
//generating the next sequence based on the previous one. 
//In each iteration, I counted consecutive identical characters and concatenated 
//the count with the character to form the next sequence. 
//I stored the current sequence in a variable and updated it in each iteration. 
//Finally, I returned the nth element of the count-and-say sequence. 
//This approach builds the sequence iteratively based on the previous one, 
//following the rules of run-length encoding.

//Time: O(4^(n/3)) because after every iteration, the length of string
//can at most increase by a factor of 4. So, after n iterations, the length can become 4^n
//but each iteration also roughly triples the length of the string, so 4^(n/3) is the time.
//Space: O(4^(n/3))
class Solution {
    public String countAndSay(int n) {
        // Initialize the current string with the first element of the sequence
        String currentString = "1";
        
        // Iterate to generate the next sequence up to the nth element
        for (int i = 2; i <= n; i++) {
            // Initialize an empty string to store the next sequence
            StringBuilder nextString = new StringBuilder();
            
            // Iterate through the current string to generate the next sequence
            for (int j = 0, k = 0; j < currentString.length(); j = k) {
                // Count consecutive identical characters
                while (k < currentString.length() && currentString.charAt(k) == currentString.charAt(j)) {
                    k++;
                }
                // Append the count and character to the next sequence
                nextString.append(k - j).append(currentString.charAt(j));
            }
            
            // Update the current string with the generated next sequence
            currentString = nextString.toString();
        }
        
        // Return the nth element of the count-and-say sequence
        return currentString;
    }
}
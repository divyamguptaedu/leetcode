//I iterated through the string, maintaining a StringBuilder to mimic stack behavior.
//Whenever I encountered a character that matches the top of the stack, 
//I popped the stack, simulating the removal of adjacent duplicates. 
//Otherwise, I pushed the current character onto the stack. 
//Finally, I returned the StringBuilder as a string. 

//Time: O(n) where n is the string length
//Space: O(n-d) where d is the total length for all duplicates
class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder(); // StringBuilder to mimic stack behavior
        int sbLength = 0; // Length of StringBuilder
        for (char character : S.toCharArray()) {
            // Check if the current character matches the top of the stack
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength - 1); // Remove the top of the stack
                sbLength--;
            } else {
                sb.append(character); // Push the current character onto the stack
                sbLength++; // Update the length of the StringBuilder
            }
        }
        return sb.toString(); // Convert StringBuilder to string
    }
}

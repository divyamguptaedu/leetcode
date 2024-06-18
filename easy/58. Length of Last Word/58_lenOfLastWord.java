//I traversed the string s from the end to the beginning, using a pointer p to track the 
//current position. I initialized a variable length to count the characters of the last word. 
//As I moved the pointer backward, I incremented length whenever I encountered a non-space 
//character. If I encountered a space after counting some characters, 
//I returned the length as the length of the last word. If the loop completed without 
//encountering a space after the last word, I returned length.

//Time: n
//Space: constant
class Solution {
    public int lengthOfLastWord(String s) {
        int position = s.length();
        int length = 0;
        
        // Traverse the string from the end
        while (position > 0) {
            position--;
            // If the character is not a space, increment length
            if (s.charAt(position) != ' ') {
                length++;
            } 
            // If we find a space after counting characters, return the length
            else if (length > 0) {
                return length;
            }
        }
        
        // Return the length of the last word
        return length;
    }
}
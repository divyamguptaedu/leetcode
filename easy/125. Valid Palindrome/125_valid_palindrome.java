//I used the two pointer approach by iterating over the string from both ends, skipping non-alphanumeric characters and 
//comparing the remaining characters. If at any point, the characters didn't match (ignoring case), 
//I returned false. If the loop completed without mismatches, I returned true.
//Time: O(n)
//Space: O(1)
class Solution {
    public boolean isPalindrome(String s) {
        // Initialize two pointers
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            // Move the left pointer forward if the character is not alphanumeric
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // Move the right pointer backward if the character is not alphanumeric
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            // Compare the characters, ignoring case
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        // All characters matched, it's a palindrome
        return true;
    }
}

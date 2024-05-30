//I implemented a function to check if a string is a palindrome. 
//Then, in the validPalindrome method, 
//I utilized two pointers to iterate from the start and end of the string simultaneously. 
//If a mismatched pair is found, I attempt to delete either the character at the left pointer 
//or the right pointer and recursively check if the resulting substring is a palindrome. 
//If either deletion results in a palindrome, I return true; otherwise, false. 
//This approach efficiently handles the deletion of at most one character to form a palindrome.

//Time: O(n)
//Space: O(1)
class Solution {
    private boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            // Found a mismatched pair - try both deletions
            if (s.charAt(i) != s.charAt(j)) {
                return (checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j));
            }

            i++;
            j--;
        }

        return true;
    }
}
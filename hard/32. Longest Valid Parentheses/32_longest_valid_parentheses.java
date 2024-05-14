//Used a two-pass approach to find the length of the longest valid parentheses substring. 
//It iterates through the string twice, once from left to right and then from right to left. 
//Within each iteration, it keeps track of the count of open and close parentheses. 
//When the counts are equal, it updates the maxlength with the current length of valid parentheses. 
//If the counts become invalid, it resets them. By considering both directions, it ensures capturing all possible valid substrings. 

//Time: 0(n)
//Space: O(1)
public class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
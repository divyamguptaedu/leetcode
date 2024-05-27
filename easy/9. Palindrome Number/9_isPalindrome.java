//I approach this problem by first handling special cases: 
//negative numbers and numbers ending with 0 (except for 0 itself), as they can't form palindromes. 
//Then, I use a while loop to reverse the second half of the number and compare it with the first half. 
//If they match, it's a palindrome. 
//To handle odd-length numbers, I ignore the middle digit in the comparison. 
//If the original number is less than the reversed number, it means I've processed half of the digits.

//Time: O(log10(n))
//Space: O(1)
class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + (x % 10);
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by
        // revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x =
        // 12,
        // revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to
        // itself), we
        // can simply get rid of it.
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
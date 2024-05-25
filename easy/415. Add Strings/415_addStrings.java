//I iterated through the digits of both strings from right to left, maintaining a sum and carry for each digit pair. 
//I initialized two pointers at the end of each string and a StringBuilder to construct the result. 
//In each iteration, I added the current digits and the carry, updating the carry for the next iteration. 
//After processing all digits, I checked if there was a remaining carry and appended it. 
//Finally, I reversed the StringBuilder to obtain the final sum in the correct order.

//Time: O(max(m,n)) where m and n are the lengths of nums1 and nums2.
//Space: O(max(m,n))
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1; // Pointer for the last digit of num1
        int j = num2.length() - 1; // Pointer for the last digit of num2
        int sum = 0, carry = 0; // Variables to store sum and carry
        StringBuilder sb = new StringBuilder(); // StringBuilder to build the result

        // Loop through both strings from the end to the beginning
        while (i >= 0 || j >= 0) {
            sum = carry; // Start with the carry from the previous iteration
            if (i >= 0) {
                sum += num1.charAt(i) - '0'; // Add the digit from num1
                i--; // Move to the next digit
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0'; // Add the digit from num2
                j--; // Move to the next digit
            }
            carry = sum / 10; // Calculate the new carry
            sum = sum % 10; // Get the last digit of the sum
            sb.append(sum); // Append the digit to the result
        }

        // If there's a remaining carry, append it to the result
        if (carry != 0) {
            sb.append(carry);
        }

        // Reverse the result to get the correct order
        return sb.reverse().toString();
    }
}
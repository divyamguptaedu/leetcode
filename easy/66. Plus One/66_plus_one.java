//I start by traversing the array from the end. 
//If a digit is 9, I set it to 0 and move to the next digit. 
//When I find a digit that is not 9, I increment it by 1 and return the array since the job is done. 
//If all digits are 9, I create a new array with length one more than the input array, 
//set the first digit to 1, and return the new array.

//Time: O(n)
//Space: O(n)
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Move along the input array starting from the end
        for (int idx = n - 1; idx >= 0; --idx) {
            // Set all the nines at the end of the array to zeros
            if (digits[idx] == 9) {
                digits[idx] = 0;
            }
            // Here we have the rightmost not-nine
            else {
                // Increase this rightmost not-nine by 1
                digits[idx]++;

                // and the job is done
                return digits;
            }
        }

        // We're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
//I used two variables, firstNum and secondNum, to keep track of the smallest and 
//second smallest numbers encountered so far in the array. I iterated through the array, 
//updating firstNum if the current number was smaller or equal, and secondNum 
//if the current number was greater than firstNum but smaller or equal to secondNum. 
//If I found a number greater than both firstNum and secondNum, I returned true, 
//indicating that an increasing triplet subsequence existed. 
//If the loop completed without finding such a number, I returned false.

//Time: n
//Space: constant
class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Initialize first and second smallest numbers to maximum value
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        
        // Iterate through the array
        for (int num : nums) {
            // Update firstNum if current num is smaller or equal
            if (num <= firstNum) {
                firstNum = num;
            } 
            // Update secondNum if current num is greater than firstNum but smaller or equal to secondNum
            else if (num <= secondNum) {
                secondNum = num;
            } 
            // If current num is greater than both firstNum and secondNum, return true
            else {
                return true;
            }
        }
        
        // If no increasing triplet subsequence found, return false
        return false;
    }
}
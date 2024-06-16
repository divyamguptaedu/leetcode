//I initialized a count to zero and a candidate variable to zero as well. 
//As I iterated through the array, I checked if the count was zero to assign the current number 
//as the candidate. If the current number matched the candidate, 
//I increased the count; otherwise, I decreased it. 
//The candidate remaining after the loop was the majority element, 
//as it appeared more than half the time.

//Time: n
//Space: constant
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0; // Initialize count to zero
        int candidate = 0; // Variable to store potential majority element

        for (int num : nums) {
            if (count == 0) { // If count is zero, select new candidate
                candidate = num;
            }
            if (num == candidate) {
                count += 1; // Increase count if current element is the candidate
            } else {
                count -= 1; // Decrease count if current element is not the candidate
            }
        }

        return candidate; // Return the candidate which is the majority element
    }
}
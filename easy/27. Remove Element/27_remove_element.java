//To remove all occurrences of a given value from an integer array in-place, 
//I used a two-pointer approach. I initialized a pointer i to traverse the array 
//and another pointer n as the effective length of the array. 
//When nums[i] equaled the target value, I replaced it with the last element 
//(nums[n-1]) and reduced n by one. If the value was not the target, I incremented i. 
//This method allowed me to overwrite the elements to be removed and 
//return the new length of the modified array.

//Time: n
//Space: constant
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
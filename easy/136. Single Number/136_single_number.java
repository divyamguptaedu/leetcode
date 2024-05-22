//I solved the problem by using the XOR operator. 
//I initialized a variable a to 0. Then, I iterated through each number in the array nums, 
//applying the XOR operation between a and each number. 
//The XOR operation cancels out all numbers that appear twice, 
//leaving only the number that appears once. 
//Finally, I returned the value of a, which held the single number 
//that didn’t have a duplicate in the array.

//Time: O(n)
//Space: O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
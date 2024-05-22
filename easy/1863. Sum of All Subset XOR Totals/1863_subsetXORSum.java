//If we see the by taking examples, we basically just need to do OR between all elements and then
//shift it left n-1 times.
//I used a bitwise approach to solve the problem. 
//First, I initialized result to 0. Then, I iterated over each number in nums and 
//performed a bitwise OR operation to combine all bits that are set in any number. 
//This step captured all the significant bits present in the array. 
//After that, I calculated the total sum of XORs for all subsets by left-shifting result by 
//nums.length - 1. This shift multiplied the combined bits by 2^(n-1), 
//accounting for each subset where these bits contribute.

//Time: O(n)
//Space: O(1)
class Solution {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        // Capture each bit that is set in any of the elements
        for (int num : nums) {
            result |= num; //bitwise or
        }
        // Multiply by the number of subset XOR totals that will have each bit set
        return result << (nums.length - 1); //shift by n-1 places to add n-1 zeros on the right
    }
}
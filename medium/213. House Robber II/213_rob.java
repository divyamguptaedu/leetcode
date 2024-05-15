//We tackled this problem by breaking it down into two separate scenarios: 
//one where the thief robs from the first house to the second-to-last house, 
//and another where the thief starts robbing from the second house to the last house. 
//These scenarios ensure that no adjacent houses are robbed together.
//I created a helper function to calculate the maximum amount the thief could rob within a given range of houses.
//This function employs a similar dynamic programming strategy to the House Robber problem, 
//updating two variables (t1 and t2) to keep track of the maximum values obtained.
//In the main function, I computed the maximum amount the thief could rob for each scenario and 
//returned the maximum of the two values obtained. 

//Time: O(N)
//Space: O(1)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int max1 = rob_simple(nums, 0, nums.length - 2);
        int max2 = rob_simple(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    public int rob_simple(int[] nums, int start, int end) {
        int t1 = 0;
        int t2 = 0;

        for (int i = start; i <= end; i++) {
            int temp = t1;
            int current = nums[i];
            t1 = Math.max(current + t2, t1);
            t2 = temp;
        }

        return t1;
    }
}
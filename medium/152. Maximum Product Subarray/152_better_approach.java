"""
Performance:
Runtime: 1 ms, faster than 92.02% of Java online submissions for Maximum Product Subarray.
Memory Usage: 39 MB, less than 32.32% of Java online submissions for Maximum Product Subarray.
"""

class Solution {
    public int maxProduct(int[] nums) {

        int maximum = nums[0];  //Stores maximum positive
        int minimum = nums[0];  //Stores minimum negative
        int answer = nums[0];   //Stores maximum of above

        for(int i = 1; i < nums.length; i++) {

            int first = nums[i];         //First Possibility
            int second = maximum * nums[i];   //Second Possibility
            int third = minimum * nums[i];    //Third Possibility

            minimum = Math.min(Math.min(first, second), third);
            maximum = Math.max(Math.max(first, second), third);

            answer = Math.max(answer, maximum);
        }

        return answer;
    }
}
//I used a two-pointer approach to solve this problem. 
//I initialized pointers at the start and end of the height array, 
//along with variables to track the maximum heights on both sides. 
//I iterated through the array, comparing the left and right maximums. 
//If the left maximum was less than or equal to the right maximum, 
//I calculated trapped water at the current left position, moved the left pointer right, 
//and updated the left maximum. Otherwise, I did the same for the right side. 
//This continued until the pointers met, and I summed the trapped water.

//Time: O(n)
//Space: O(1)
class Solution {
    public int trap(int[] height) {
        int i = 0, left_max = height[0], sum = 0;
        int j = height.length - 1, right_max = height[j];
        while (i < j) {
            if (left_max <= right_max) {
                sum += (left_max - height[i]);
                i++;
                left_max = Math.max(left_max, height[i]);
            } else {
                sum += (right_max - height[j]);
                j--;
                right_max = Math.max(right_max, height[j]);
            }
        }
        return sum;

    }
}
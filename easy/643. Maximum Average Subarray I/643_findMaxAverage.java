//We first just get the first window sum, then start moving the window by decreasing the sum by the chopped
//off left element and adding the right element, recalulate the max, and return the avg of the max.

//Time: O(n)
//Space: O(1)
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) { //get the first window sum
            sum += nums[i];
        }
        double res = sum; //save the sum
        for (int i = k; i < nums.length; i++) { //chop off the leftmost and add the next right
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum); //keep the max
        }
        return res / k; //find the avg and return
    }
}

//Tracking different sum combinations.
//I utilized dynamic programming to track the count of different sum combinations. 
//Initially, I calculated the total sum of the array elements and created a 2D dynamic programming array. 
//I initialized the array with counts based on the first element's positivity or negativity. 
//Then, iterating through the elements, I updated the dynamic programming array considering all possible sums. 
//Finally, I returned the count of assignments corresponding to the target sum. 

//Time: O(tn) where t is the sum of the array and n is the length of the array
//Space: O(tn)
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * total + 1]; //the sum can range from -total to total, including 0
        dp[0][nums[0] + total] = 1; //if first number is taken as positive we mark that value as 1
        dp[0][-nums[0] + total] += 1; //if first number is taken as negative we mark that value as 1, do += here for the case when nums[0] = 0.
        
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -total; sum <= total; sum++) {
                if (dp[i - 1][sum + total] > 0) {
                    dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
                    dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
                }
            }
        }
        
        return Math.abs(S) > total ? 0 : dp[nums.length - 1][S + total];
    }
}
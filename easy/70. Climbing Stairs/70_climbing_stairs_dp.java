//For this question, we can use DP and use the last two assignments to get the current step possibilities. But, this is essentially
//a fibonacci series, and we just need the nth number. So, why not use this to save on the space complexity by avoiding keeping a dp array.
//So, below is a code for dp approach, followed by the efficient code. Use the second one. 

//For the efficient approach, we will iterate from 3 to n, updating variables first and second, 
//representing the number of ways to reach the current step.
//At each step, it calculates the number of ways to reach the current step by summing the ways to reach the two preceding steps. 
//Finally, it returns the number of ways to reach the nth step, which represents the top of the staircase.
//Time: O(n)
//Space: O(1)
// public class Solution {
//     public int climbStairs(int n) {
//         if (n == 1) {
//             return 1;
//         }
//         int[] dp = new int[n + 1];
//         dp[1] = 1;
//         dp[2] = 2;
//         for (int i = 3; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }
//         return dp[n];
//     }
// }

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
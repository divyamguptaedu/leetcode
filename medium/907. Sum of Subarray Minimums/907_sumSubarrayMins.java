//I approached the problem by using a monotonic increasing stack to keep track of the previous 
//smaller elements for each element in the array. For each element, I calculated the sum of the 
//minimums of all subarrays ending at that element by using a dynamic programming array (dp). 
//This array stored the cumulative contributions of subarrays ending at each index. 
//The final result was obtained by summing up all values in the dp array and taking the result modulo.
//Time: n
//Space: n
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[arr.length];

        // Iterate through the array to populate dp array using a monotonic increasing stack
        for (int i = 0; i < arr.length; i++) {
            // Maintain the stack to keep elements in increasing order
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            // Calculate dp[i] based on the previous smaller element if it exists
            if (!stack.isEmpty()) {
                int previousSmaller = stack.peek();
                dp[i] = dp[previousSmaller] + (i - previousSmaller) * arr[i];
            } else {
                // If no previous smaller element, consider all subarrays ending at i
                dp[i] = (i + 1) * arr[i];
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        // Sum up all elements in the dp array to get the final answer
        long sumOfMinimums = 0;
        for (int value : dp) {
            sumOfMinimums += value;
            sumOfMinimums %= MOD;
        }

        return (int) sumOfMinimums;
    }
}
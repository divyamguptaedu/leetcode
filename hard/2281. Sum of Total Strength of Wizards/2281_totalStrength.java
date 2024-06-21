//I first computed prefix sums and prefix of prefix sums to handle subarray sums efficiently. 
//I used a stack to maintain indices of the strength array, ensuring a non-decreasing order. 
//For each wizard, I determined the range in which the current wizard's strength is the weakest. 
//I calculated the total strength for all subarrays where the current wizard is the weakest by using 
//the precomputed sums and adjusted the result using modulo operations to handle large numbers. 
//The final result was accumulated and returned as the sum of the total strengths of all contiguous 
//groups of wizards.

//Time: n
//Space: n
class Solution {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int MOD = 1000000007;

        // Compute prefix sums
        long[] prefixSums = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = (prefixSums[i - 1] + strength[i - 1]) % MOD;
        }

        // Compute prefix of prefix sums
        long[] prefixOfPrefixSums = new long[n + 2];
        for (int i = 1; i <= n + 1; i++) {
            prefixOfPrefixSums[i] = (prefixOfPrefixSums[i - 1] + prefixSums[i - 1]) % MOD;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        long result = 0;

        for (int i = 0; i <= n; i++) {
            // Maintain a non-decreasing stack
            while (!stack.isEmpty() && (n == i || strength[stack.peek()] >= strength[i])) {
                int idx = stack.pop();
                int rightBoundary = i;
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int leftRange = idx - leftBoundary;
                int rightRange = rightBoundary - idx;

                // Calculate positive and negative sums
                long posSum = prefixOfPrefixSums[idx + rightRange + 1] - prefixOfPrefixSums[idx + 1];
                long negSum = prefixOfPrefixSums[idx + 1] - prefixOfPrefixSums[idx - leftRange + 1];

                // Update the result
                result = (result + (posSum * leftRange - negSum * rightRange) % MOD * strength[idx] % MOD) % MOD;
            }
            stack.push(i);
        }

        return (int) (result + MOD) % MOD;
    }
}
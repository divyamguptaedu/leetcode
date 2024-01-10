"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
Memory Usage: 35.6 MB, less than 71.36% of Java online submissions for Climbing Stairs.
"""
class Solution {
    public int climbStairs(int n) {
        
        // array to store the number of distinct ways from 'n'.
        int[] storage = new int[n + 1];

        return climbStairsHelper(n, storage);
    }
    
    private int climbStairsHelper(int n, int[] storage) {

        // base case if two steps left
        if (n == 2) {
            return 2;
        }

        // base case if one step left
        if (n == 1) {
            return 1;
        }

        // base case if no steps left
        if (n == 0) {
            return 0;
        }

        // check if number of distinct ways from 'n' is already calculated.
        if (storage[n] > 0) {
            return storage[n];
        }

        // use recursion to go down one and two steps.
        int downOneStep = climbStairsHelper(n - 1, storage);
        int downTwoStep = climbStairsHelper(n - 2, storage);

        // add to the storage for a possible future usage.
        storage[n] = downOneStep + downTwoStep;
        return downOneStep + downTwoStep;
    }
}
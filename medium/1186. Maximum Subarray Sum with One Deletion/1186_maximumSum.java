//I approached this problem by breaking it down into two phases: 
//calculating the maximum sum of non-empty subarrays from the beginning to the end (forward)
//d from the end to the beginning (backward). 
//During both phases, I kept track of the maximum sum achievable with or without deletion. 
//In the first phase, I iterated through the array, updating the current maximum sum and 
//storing it in the forward array. 
//In the second phase, I iterated through the array backward, 
//performing similar operations as in the first phase and storing the results in the
// backward array. Finally, I compared the maximum sums obtained with different deletion s
// cenarios and returned the maximum value.

// //Time: O(n)
//Space: O(n)
class Solution {
    public int maximumSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] forward = new int[arr.length];
        int[] backward = new int[arr.length];
        int max = arr[0];
        int currentMax_forward = 0;
        int currentMax_backward = 0;

        for (int i = 0; i < arr.length; i++) {
            currentMax_forward = Math.max(arr[i], arr[i] + currentMax_forward);
            forward[i] = currentMax_forward;
            max = Math.max(max, currentMax_forward); // keeping a track of maximum possible sum with deletion
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            currentMax_backward = Math.max(arr[i], arr[i] + currentMax_backward);
            backward[i] = currentMax_backward;
        }

        /**
         * keeping a track of maximum possible sum with single deletion!
         * Here we are starting deletion from arr[1] to arr[length-2] index
         */
        for (int i = 0; i < arr.length - 2; i++) {
            max = Math.max(max, forward[i] + backward[i + 2]);
        }

        max = Math.max(max, backward[1]); // lastly we compare the maximum by deleting arr[0] since we have already ran
                                          // comparisons for all other permutations above
        return max;
    }
}
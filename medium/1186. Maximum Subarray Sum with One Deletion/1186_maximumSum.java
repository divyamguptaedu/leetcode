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
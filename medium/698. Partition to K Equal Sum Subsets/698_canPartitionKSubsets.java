//I aimed to divide an array into k subsets with equal sums using backtracking. 
//I first calculated the total sum of the array elements and sorted the array in descending order. 
//Then, I recursively tried different combinations of elements, keeping track of which elements were already taken. 
//If the current sum equaled the target sum (total sum divided by k), I moved on to the next subset. 
//I continued this process until k - 1 subsets were formed with the target sum. 
//If all elements were used and all subsets were formed, I returned true; otherwise, I returned false.

//Time: O(k * 2^n) //k is #subsets, n is #elements
//Space: O(n)
class Solution {
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            totalArraySum += arr[i];
        }
        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }
        // Sort in decreasing order.
        Arrays.sort(arr);
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { //reversing for descending order
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int targetSum = totalArraySum / k;
        boolean[] taken = new boolean[n];
        return backtrack(arr, 0, 0, 0, k, targetSum, taken);
    }

    private boolean backtrack(int[] arr, int index, int count, int currSum, int k, int targetSum, boolean[] taken) {
        int n = arr.length;
        // We made k - 1 subsets with target sum and last subset will also have target
        // sum.
        if (count == k - 1) { //as soon as we have k - 1 subsets, we are good to stop, because we know the total sum.
            return true;
        }
        // No need to proceed further.
        if (currSum > targetSum) {
            return false;
        }
        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            return backtrack(arr, 0, count + 1, 0, k, targetSum, taken);
        }
        // Try not picked elements to make some combinations.
        for (int j = index; j < n; ++j) {
            if (!taken[j]) {
                // Include this element in current subset.
                taken[j] = true;
                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, taken)) {
                    return true;
                }
                // Backtrack step.
                taken[j] = false;
            }
        }
        // We were not able to make a valid combination after picking each element from
        // the array,
        // hence we can't make k subsets.
        return false;
    }
}
//I iterated through the array once, calculating the total sum. 
//Then, I checked if the sum could be evenly divided into three parts. 
//If not, I returned false. 
//If it could, I set the target sum for each part. 
//While iterating through the array again, I accumulated the sum of elements. 
//When the accumulated sum matches the target, I reset the sum and increment the count. 
//If I find two such sums, I return true, indicating the array can be partitioned into
//three parts with equal sums.

//Time: n
//Space: constant
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        // Calculate the total sum of the array elements
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // If the total sum cannot be divided evenly into three parts, return false
        if (totalSum % 3 != 0) {
            return false;
        }

        // Calculate the target sum for each part
        int targetSum = totalSum / 3;
        int currentSum = 0;
        int count = 0;

        // Iterate through the array to find two partitions with equal sums
        for (int i = 0; i < arr.length - 1; i++) {
            currentSum += arr[i];
            // If the current sum equals the target sum, reset the sum and increment count
            if (currentSum == targetSum) {
                currentSum = 0;
                count++;
                // If two partitions with equal sums are found, return true
                if (count == 2) {
                    return true;
                }
            }
        }

        // If two partitions with equal sums are not found, return false
        return false;
    }
}
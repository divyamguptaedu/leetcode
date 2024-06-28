//I approached the problem by first calculating the total sum of the array. 
//For each index, I computed the prefix sum up to that index and used it to determine the average 
//of the left part of the array. I then subtracted the prefix sum from the total sum to get the sum 
//of the right part and calculated its average. I tracked the index with the minimum average 
//difference between the left and right parts and returned that index.
//Time: n
//Space: constant
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int resultIndex = -1;
        int minAverageDifference = Integer.MAX_VALUE;
        long currentPrefixSum = 0;

        // Calculate the total sum of the array
        long totalSum = 0;
        for (int index = 0; index < n; ++index) {
            totalSum += nums[index];
        }

        // Iterate through each index to find the minimum average difference
        for (int index = 0; index < n; ++index) {
            currentPrefixSum += nums[index];

            // Calculate the average of the left part of the array (0 to index)
            long leftPartAverage = currentPrefixSum / (index + 1);

            // Calculate the average of the right part of the array (index+1 to n-1)
            long rightPartAverage = totalSum - currentPrefixSum;
            if (index != n - 1) {
                rightPartAverage /= (n - index - 1);
            }

            // Calculate the current difference between the two averages
            int currentDifference = (int) Math.abs(leftPartAverage - rightPartAverage);

            // Update the minimum average difference and result index if needed
            if (currentDifference < minAverageDifference) {
                minAverageDifference = currentDifference;
                resultIndex = index;
            }
        }

        return resultIndex;
    }
}

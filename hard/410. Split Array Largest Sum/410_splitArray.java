//I employed a binary search strategy to minimize the largest sum of the split subarrays. 
//The main idea was to efficiently determine the smallest possible value for the largest sum 
//such that the array nums can be split into exactly m subarrays.
//First, I calculated the boundaries for the binary search: left was initialized to the maximum 
//element in nums, and right to the sum of all elements in nums. Then, using binary search, 
//I iteratively adjusted left and right based on whether the current midpoint (maxSumAllowed) 
//could accommodate the array split into m or fewer subarrays.
//The minimumSubarraysRequired function helped determine how many subarrays are needed if each 
//subarray's sum doesn't exceed maxSumAllowed. Based on this count, 
//I adjusted the search boundaries to converge on the minimum possible largest sum.

//Time: N log S where n is the length of nums, s is the sum of integers in the array.
//Space: constant
class Solution {
    private int minimumSubarraysRequired(int[] nums, int maxSumAllowed) {
        int currentSum = 0;
        int splitsRequired = 0;

        for (int element : nums) {
            // Add element only if the sum doesn't exceed maxSumAllowed
            if (currentSum + element <= maxSumAllowed) {
                currentSum += element;
            } else {
                // If the element addition makes sum more than maxSumAllowed
                // Increment the splits required and reset sum
                currentSum = element;
                splitsRequired++;
            }
        }

        // Return the number of subarrays, which is the number of splits + 1
        return splitsRequired + 1;
    }

    public int splitArray(int[] nums, int m) {
        // Find the sum of all elements and the maximum element
        int sum = 0;
        int maxElement = Integer.MIN_VALUE;
        for (int element : nums) {
            sum += element;
            maxElement = Math.max(maxElement, element);
        }

        // Define the left and right boundary of binary search
        int left = maxElement;
        int right = sum;
        int minimumLargestSplitSum = 0;
        while (left <= right) {
            // Find the mid value
            int maxSumAllowed = left + (right - left) / 2;

            // Find the minimum splits. If splitsRequired is less than
            // or equal to m move towards left i.e., smaller values
            if (minimumSubarraysRequired(nums, maxSumAllowed) <= m) {
                right = maxSumAllowed - 1;
                minimumLargestSplitSum = maxSumAllowed;
            } else {
                // Move towards right if splitsRequired is more than m
                left = maxSumAllowed + 1;
            }
        }

        return minimumLargestSplitSum;
    }
}
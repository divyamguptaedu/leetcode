//Because we want the close numbers to be together, we can first sort the given array.
//After sorting, we can have the left and right pointer and the sum.
//We will iterate on the array using the right pointer. The right pointer will be considered the target.
//We will check if it is possible to make every element equal to the target using k operations.
//If not, we will increment the left pointer and remove its value from the sum.
//In the end, we will return the length of the window which can be found by doing n - left.
//We will never decrease the size of the window, since there is no point in doing that.

//Time: O(nlogn) - nlogn for sorting, n for sliding window
//Space: O(log n) - Java uses quick sort which takes logn space
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long currentSum = 0;
        
        for (int right = 0; right < nums.length; right++) {
            int target = nums[right];
            currentSum += target;
            
            if ((right - left + 1) * target > currentSum + k) { //if it's not possible to make every elemnent in this window equal to target
                currentSum -= nums[left];
                left++;
            }
        }
        
        return nums.length - left;
    }
}
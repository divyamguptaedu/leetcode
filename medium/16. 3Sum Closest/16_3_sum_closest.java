//I sorted the input array and iterated through it. 
//Within each iteration, I used two pointers to find the closest sum to the target
//by adjusting the pointers based on the comparison of the current sum with the target. 
//I maintained the minimum difference between the current sum and the target. 
//By continually updating this difference, I found the closest sum. 
//Finally, I returned the sum closest to the target.

//Time: n^2
//Space: logn for sorting.
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestDifference = Integer.MAX_VALUE;
        int size = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < size && closestDifference != 0; ++i) {
            int leftPointer = i + 1;
            int rightPointer = size - 1;
            
            while (leftPointer < rightPointer) {
                int sum = nums[i] + nums[leftPointer] + nums[rightPointer];
                
                if (Math.abs(target - sum) < Math.abs(closestDifference)) {
                    closestDifference = target - sum;
                }
                
                if (sum < target) {
                    ++leftPointer;
                } else {
                    --rightPointer;
                }
            }
        }
        return target - closestDifference;
    }
}
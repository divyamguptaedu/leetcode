//We are going to use a binary search approach to solve this question. 
//First, we will have a low and high as 0 and nums.length - 1. Then we will start the traditional while loop.
//We get the mid value, if the middle value is the target, we return the mid.
//If not, then we check if the left half is sorted. If sorted, and if the target lies in it, then we move the high to mid - 1, if not, we move the low to mid + 1.
//If not, then we check if the right half is sorted. If sorted, and if the target lies in it, we move the low to be mid + 1, if not, we move the high to be mid - 1.

//Time: O(logn)
//Space: O(1)
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) { //First condition
                return mid;
            }
            if (nums[low] <= nums[mid]) { //second condition
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { //third condition
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1; //not found
    }
}
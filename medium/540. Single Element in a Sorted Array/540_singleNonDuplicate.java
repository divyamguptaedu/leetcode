//The single element we need to find at some even index not followed by its pair. We will use binary search to find that location.
//We set low as 0, high as len - 1, and calculate the mid.
//If the mid is a odd position, we decrease it by one to make it even.
//Now we check, if the nums[mid] == nums[mid + 1], it means that the single element lies in the right half, so low = mid + 2.
//If not, then high = mid since maybe mid is the element we need.
//In the end, we return nums[low].

//Time: O(logn)
//Space: O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
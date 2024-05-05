//To solve this question, we can use binary search approach. We will first do binary search to get the first occurence
//then do binary search again to get the last occurence.
//So, we will start with traditional approach, with only modification in a case where the mid == target.
//If the middle == target, then we check if we are looking for the first or last occurance.
//Based on that, if looking for first, we check if mid == low || nums[mid - 1] != target, if yes, we found it, if not, we redo binary search on the left half.
//If looking for last occurence, we check if mid == high || nums[mid + 1] != target, if yes, we found it, if not, we redo binary search on the right half.

//Time: O(logn)
//Space: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = this.findBound(nums, target, true);

        if (firstOccurrence == -1) {
            return new int[] { -1, -1 };
        }

        int lastOccurrence = this.findBound(nums, target, false);

        return new int[] { firstOccurrence, lastOccurrence };
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int low = 0;
        int high = N - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                if (isFirst) {
                    // This means we found our lower bound.
                    if (mid == low || nums[mid - 1] != target) {
                        return mid;
                    }

                    // Search on the left side for the bound.
                    high = mid - 1;
                } else {
                    // This means we found our upper bound.
                    if (mid == high || nums[mid + 1] != target) {
                        return mid;
                    }

                    // Search on the right side for the bound.
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
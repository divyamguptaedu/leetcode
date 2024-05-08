//To solve this question, we can use binary search approach. We set the left and right pointers, calculate the mid
//and then check how many missing indexes do we have on the left taking the value on that index minus the first value in the array minus the mid index.
//If there is less numbers missing on the left, i.e we chose the right half, otherwise, we chose the left half.
//In the end, we return the kth missing element by taking the first element in the array + k + left index.

//Time: O(logn)
//Space: O(1)
class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = right - (right - left) / 2; //doing left+right will give TLE when left and right are very large
            if (nums[mid] - nums[0] - mid < k) { //how many missing indexes on the left
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return nums[0] + k + left;
    }
}
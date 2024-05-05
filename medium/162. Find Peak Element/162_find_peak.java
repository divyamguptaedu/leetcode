//Note the third constraint in the problem.

//We can solve this question using binary search approach. While, in traditional binary search, 
//after finding the middle value, we run some logic to cancel out one half of the array, however, 
//in this question, we cannot do that, since there can be multiple peek elements.
//So, what we can do is, we can chose a half which is guranteed to have a peek element. 
//And we can check that by checking if nums[mid] < nums[mid + 1], i.e it's gurateed to have a peek element
//in the right half because either the numbers will keep on increasing and the rightmost will become the peek
//or there will be a dip, and we will get a peek element.
//If nums[mid] > nums[mid+1], then we can guarantee that there will be a peek element on the left.

//Time: O(logn)
//Space: O(1)
public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
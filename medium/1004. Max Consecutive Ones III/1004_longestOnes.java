//We can use a simple sliding window approach to solve this question. We will just initialize the left and right.
//Then we will do a for loop on the right pointer, if the right pointer has a zero, we will reduce k
//Which means that we are considering that it will be flipped.
//Once the k is negative, i.e. we have flipped more than allowed zeros, we will increment the left
//And also make sure to increase the k back if the chopped off element is a 0.
//This will give us the largest window and we will return the difference between the right and left.

//Time: O(n)
//Space: O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                k += 1 - nums[left];
                left++;
            }
        }     
        return right - left;
    }
}
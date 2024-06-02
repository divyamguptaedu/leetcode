//I iteratively merge two sorted arrays nums1 and nums2 into nums1 itself. 
//I initialize pointers p1 and p2 to the end of each array and iterate backwards. 
//At each step, I compare elements at p1 and p2, and place the larger element at the end of nums1. 
//I decrement the respective pointer (p1 or p2) based on the comparison. 
//If p2 reaches the start before p1, I break the loop, as all elements from nums2 are merged into nums1. 

//Time: O(n+m)
//Space: O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int p1 = m - 1;
        int p2 = n - 1;

        // And move p backward through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}
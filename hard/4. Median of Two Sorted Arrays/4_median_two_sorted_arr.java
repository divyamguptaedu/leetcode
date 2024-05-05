//We can solve this question using binary search approach over the smaller of the two arrays.
//The main idea is to find a point of partition in both arrays such that the max of the smaller half is less than or equal to the minimum of the larger half.
//So, first we calculate the partitionA i.e. nums1, i.e. left + right / 2, partitionB can be total elements + 1 / 2 - elements in partition A 
//to understand how many more elements will be there from nums2 for the overall left partition.
//Determine the maximum value of the section A_left as maxLeftA = nums1[partitionA - 1]. If partitionA - 1 < 0, set it as maxLeftA = float(-inf).
//Determine the minimum value of the section A_right as minRightA = nums1[partitionA]. If partitionA >= m, set it as minRightA = float(inf).
//Determine the maximum value of the section B_left as maxLeftB = nums2[partitionB - 1]. If partitionB - 1 < 0, set it as maxLeftB = float(-inf).
//Determine the maximum value of the section B_right as minRightB = nums2[partitionB]. If partitionB >= n, set it as minRightB = float(inf)

//Compare maxLeftA with minRightB and maxLeftB with minRightA.
//If maxLeftA > minRightB, it means the maxLeftA is too large to be in the smaller half, so we update right = partitionA - 1 to move to the left half of the search space.
//If maxLeftB > minRightA, it means that we are too far on the left side for partitionA and we need to go to the right half of the search space by updating left = partitionA + 1.

//When both maxLeftA <= minRightB and maxLeftB <= minRightA are true, we can find the median based on odd or element elements.

//Time: O(log(min(m, n))) we perform binary search over the smaller array of size min(m,n)
//Space: O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); //we want nums1.length to be smaller than nums2.length
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;

        while (left <= right) {
            int partitionA = (left + right) / 2; //middle value in nums1, represents left partition of nums1
            int partitionB = (m + n + 1) / 2 - partitionA; //represents left partition on nums2

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1]; //max value of nums1 left
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA]; //min value of nums1 right
            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1]; //max value of nums2 left
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB]; //min value of nums2 right

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) { //means we found the left partition
                if ((m + n) % 2 == 0) { //even elements, take the mean
                    return ((Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0);
                } else { //return the maximum of the middle
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) { //is maxLeftA too large to be in smaller half
                right = partitionA - 1; //move to left half of the search space
            } else {
                left = partitionA + 1; //move to right half of the search space
            }
        }
        return 0.0; //can return anything
    }
}
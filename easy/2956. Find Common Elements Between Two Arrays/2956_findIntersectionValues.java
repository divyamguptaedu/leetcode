//check constraints for the array, should be 100. So, array size 101.

//I initialized two arrays to track the presence of elements from each array. 
//Then, I iterated through each array, marking the presence of elements in their
//respective tracking arrays. Afterward, I iterated through each array again,
//counting the occurrences of elements from the opposite array in the tracking arrays.
//Finally, I returned the counts of occurrences for both arrays.
//This allowed me to find the number of common elements between the two arrays
//in both directions.

//Time: n + m
//Space: constant, fixed 101 elements
class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] tracker1 = new int[101];
        int[] tracker2 = new int[101];
        // Mark presence of elements from nums1
        for (int num : nums1) {
            tracker1[num] = 1;
        }
        // Mark presence of elements from nums2
        for (int num : nums2) {
            tracker2[num] = 1;
        }
        int[] commonCounts = new int[2];
        // Count occurrences of nums2 elements in nums1
        for (int num : nums1) {
            commonCounts[0] += tracker2[num];
        }
        // Count occurrences of nums1 elements in nums2
        for (int num : nums2) {
            commonCounts[1] += tracker1[num];
        }
        return commonCounts;
    }
}
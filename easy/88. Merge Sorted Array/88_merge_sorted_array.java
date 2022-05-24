"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
Memory Usage: 43.5 MB, less than 6.24% of Java online submissions for Merge Sorted Array.
"""

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int i = m + n + 1; i >= 0; i--) {
            if ((n < 0) || (m >= 0 && nums1[m] > nums2[n])) {
                nums1[i] = nums1[m];
                m--;
            }
            else {
                nums1[i] = nums2[n];
                n--;
            }
        }
    }
}
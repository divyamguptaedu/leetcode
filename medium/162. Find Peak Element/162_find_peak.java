"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
Memory Usage: 38.9 MB, less than 42.13% of Java online submissions for Find Peak Element.
"""

class Solution {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] > arr[middle + 1]) {
                end = middle;
            }
            else {
                start = middle + 1; 
            }
        }
        return start;
  }
}    
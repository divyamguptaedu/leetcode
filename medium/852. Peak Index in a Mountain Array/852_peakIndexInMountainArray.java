"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
Memory Usage: 73.5 MB, less than 5.01% of Java online submissions for Peak Index in a Mountain Array.
"

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return helper(arr, 0, arr.length - 1);
    }
    
    private int helper(int[] arr, int left, int right) {
        left = Math.max(0, left);
        right = Math.min(right, arr.length - 1);
        int middle = left + (right - left) / 2;
        if (arr[middle] > arr[middle - 1] && arr[middle] > arr[middle + 1]) {
            return middle;
        }
        
        if (arr[middle] < arr[middle + 1]) {
            return helper(arr, middle, right);
        } else {
            return helper(arr, left, middle);
        }
    }
}
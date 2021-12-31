"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find in Mountain Array.
Memory Usage: 38.7 MB, less than 84.53% of Java online submissions for Find in Mountain Array.
"""

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int top = binarySearch(mountainArr);
        int initial = helper(mountainArr, target, 0, top);
        if (initial != -1){
           return initial;
        }
        return helper(mountainArr, target, top + 1, mountainArr.length() - 1); 
    }
    
    public int binarySearch(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        while (start < end){
           int mid = start + (end - start) / 2;
           if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
               end = mid;
           } else {
               start = mid + 1;
           }
        }
        return start;
    }
    
    public int helper(MountainArray mountainArr, int target, int start, int end) {
        boolean increasing = mountainArr.get(start) < mountainArr.get(end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (increasing) {
                if (target < mountainArr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target < mountainArr.get(mid)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                } 
            }
        }
        return -1;
    }
}
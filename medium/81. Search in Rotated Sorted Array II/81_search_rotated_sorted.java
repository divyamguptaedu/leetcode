"""
Performance: 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array II.
Memory Usage: 41.8 MB, less than 93.07% of Java online submissions for Search in Rotated Sorted Array II.
"""

class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {    
          int mid = (low + high) / 2;
          if (nums[mid] == target) {
              return true;
          } else {
              while (nums[mid] == nums[low] && low < mid) {
                  low++;
              }
              if (nums[low] <= nums[mid]) {
                     if (target >= nums[low] && target < nums[mid]) {
                     high = mid - 1;
                 } else {
                     low = mid + 1; 
                 }
              } else {      
                   while (nums[mid] == nums[high] && high > mid) {
                     high--;
                   }
                   if (target > nums[mid] && target <= nums[high]) {
                     low = mid + 1;
                   } else {
                     high = mid - 1;
                   }
                }  
          }       
         }
        return false;
    }
}
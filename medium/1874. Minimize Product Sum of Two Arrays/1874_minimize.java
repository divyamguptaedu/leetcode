/*
sort both arrays
for (0 -> len) 
    first[i] * second[len - 1 - i];
*/

class Solution {    
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            result += (nums1[i] * nums2[nums2.length - 1 - i]);
        }
        return result;
    }
}
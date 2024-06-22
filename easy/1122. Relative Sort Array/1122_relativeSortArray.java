//I approached the problem by first determining the maximum value in arr1 to size an array count appropriately. 
//This array count is used to tally occurrences of each number in arr1. 
//After populating count, I then construct the result array ans by iterating through arr2 and 
//appending elements according to their counts in count. 
//Finally, I handle elements in arr1 not present in arr2 by appending them in ascending order
// based on count. This ensures the relative sorting requirement is met.
//Time: n+m
//Space: max value in arr1
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int length = 0;
        for (int i = 0; i < arr1.length; i++) {
            length = Math.max(length, arr1[i]);
        }
        int[] count = new int[length + 1];
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (count[arr2[i]] > 0) {
                ans[index] = arr2[i];
                index++;
                count[arr2[i]]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ans[index] = i;
                index++;
                count[i]--;
            }
        }
        return ans;
    }
}
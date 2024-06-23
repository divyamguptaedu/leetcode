//I used a three-pointer approach. Initially, I set up pointers (p1, p2, and p3) to track positions in each array. 
//As I iterated through the arrays simultaneously, whenever I found matching elements at these pointers (arr1[p1] == arr2[p2] == arr3[p3]), 
//I added that element to the result list. 
//If elements didn't match, I adjusted the pointers based on which array had the smallest current element. 

//Time: n, where n is the total number of elements across all three arrays
//Space: constant
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        // prepare three pointers to iterate through three arrays
        // p1, p2, and p3 point to the beginning of arr1, arr2, and arr3 accordingly
        int p1 = 0, p2 = 0, p3 = 0;

        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {

            if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
                ans.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
            } else {
                if (arr1[p1] < arr2[p2]) {
                    p1++;
                } else if (arr2[p2] < arr3[p3]) {
                    p2++;
                } else {
                    p3++;
                }

            }
        }
        return ans;
    }
}
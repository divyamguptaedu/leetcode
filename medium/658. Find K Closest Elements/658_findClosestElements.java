//We can use binary search to find the best window for this problem. 
//We initialize left to be 0 and right to be len(arr) - k as we will keep the pointer to be the leftmost point of the window.
//We perform binary search to check check if moving the window to left is better or right is better. The smaller element wins.
//At the end, we have the leftmost index for the final answer. Return the subarray.

//Time: O(log(n-k)+k) Finding the bound takes log(n-k), building the result takes O(k).
//Space: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k; //because we consider the pointer to be the leftmost element in the window
        
        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) { //what's better? Moving the window to left or right?
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}
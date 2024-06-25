//To solve the problem using merge sort, I'll implement a recursive merge sort 
//algorithm. Merge sort is a divide-and-conquer algorithm that divides the array 
//into halves, sorts each half recursively, and then merges the sorted halves. 
//This approach ensures the time complexity is O(nlogn). 
//Space: n

class Solution {
    
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // Helper method to perform merge sort
    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // Sort the first half
            mergeSort(nums, left, mid);
            // Sort the second half
            mergeSort(nums, mid + 1, right);
            // Merge the two halves
            merge(nums, left, mid, right);
        }
    }

    // Helper method to merge two sorted halves
    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays to hold the halves
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = nums[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = nums[mid + 1 + i];
        }

        // Merge the temp arrays back into the original array
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k] = leftArray[i];
                i++;
            } else {
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of leftArray
        while (i < n1) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements of rightArray
        while (j < n2) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

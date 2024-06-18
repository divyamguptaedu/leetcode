//If we can use the inbuilt sort function, then the solution is this. If not, use the next one.
//I cloned the original array heights and sorted the clone to create the expected array. 
//I then compared the original heights array with the sorted expected array element by element. 
//For each position where the elements differed, I incremented a counter. 
//The final value of this counter indicated the number of indices where the heights did not match 
//the expected order.

//Time: nlogn
//Space n
class Solution {
    public int heightChecker(int[] heights) {
        int[] sortedHeights = heights.clone();
        Arrays.sort(sortedHeights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedHeights[i]) {
                count++;
            }
        }
        return count;
    }
}

//If using the inbuilt sort is not allowed then.
//Did merge sort, and them compared.

class Solution {

    // Function to merge two sub-arrays in sorted order.
    private void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        // Calculate the start and sizes of two halves.
        int start1 = left;
        int start2 = mid + 1;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Copy elements of both halves into a temporary array.
        for (int i = 0; i < n1; i++) {
            tempArr[start1 + i] = arr[start1 + i];
        }
        for (int i = 0; i < n2; i++) {
            tempArr[start2 + i] = arr[start2 + i];
        }

        // Merge the sub-arrays in 'tempArray' back into the original array 'arr' in
        // sorted order.
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (tempArr[start1 + i] <= tempArr[start2 + j]) {
                arr[k] = tempArr[start1 + i];
                i += 1;
            } else {
                arr[k] = tempArr[start2 + j];
                j += 1;
            }
            k += 1;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = tempArr[start1 + i];
            i += 1;
            k += 1;
        }
        while (j < n2) {
            arr[k] = tempArr[start2 + j];
            j += 1;
            k += 1;
        }
    }

    // Recursive function to sort an array using merge sort.
    private void mergeSort(int[] arr, int left, int right, int[] tempArr) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        // Sort first and second halves recursively.
        mergeSort(arr, left, mid, tempArr);
        mergeSort(arr, mid + 1, right, tempArr);
        // Merge the sorted halves.
        merge(arr, left, mid, right, tempArr);
    }

    public int heightChecker(int[] heights) {
        // Sort the array using merge sort.
        int[] sortedHeights = heights.clone();
        int[] tempArray = new int[heights.length];
        mergeSort(sortedHeights, 0, sortedHeights.length - 1, tempArray);

        int count = 0;
        // Loop through the original and sorted arrays.
        for (int i = 0; i < sortedHeights.length; ++i) {
            // Increment count if elements at the same index differ.
            if (heights[i] != sortedHeights[i]) {
                count += 1;
            }
        }
        // Return the total count of differing elements.
        return count;
    }
}
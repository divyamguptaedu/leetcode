//I approached the problem by using a modified merge sort algorithm. I divided the array into two halves, recursively sorted each half, and then merged them. During the merge step, I counted the reverse pairs by comparing elements from both halves and checking if any element from the left half is greater than twice any element from the right half. This approach effectively combines counting reverse pairs with the sorting process, ensuring that the solution is both efficient and correct.
//Time: nlogn
//Space: n
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);
            count += merge(nums, low, mid, high);
        }
        return count;
    }

    private int merge(int[] nums, int low, int mid, int high) {
        int[] leftArray = Arrays.copyOfRange(nums, low, mid + 1);
        int[] rightArray = Arrays.copyOfRange(nums, mid + 1, high + 1);

        int i = 0, j = 0, k = low;
        int count = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if ((long) leftArray[i] > 2 * (long) rightArray[j]) {
                count += leftArray.length - i;
                j++;
            } else {
                i++;
            }
        }

        i = 0;
        j = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            nums[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            nums[k++] = rightArray[j++];
        }

        return count;
    }
}
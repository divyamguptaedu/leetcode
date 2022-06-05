"
Runtime: 4 ms, faster than 70.71% of Java online submissions for Maximize Sum Of Array After K Negations.
Memory Usage: 42.8 MB, less than 54.94% of Java online submissions for Maximize Sum Of Array After K Negations.
"

class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr);
        int result = 0;
        int size = arr.length;
        int temp = 0;
        while (k > 0) {
            arr[temp] *= -1;
            k--;
            if (temp + 1 < size && arr[temp] > arr[temp + 1]) temp++;
        }
        for (int item : arr) {
            result += item;
        }
        return result;
    }
}
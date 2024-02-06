class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int size = arr.length;
        int i = 0; 
        for (int j = 0; j < size; j++) {
            if (arr[j] % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        return arr;
    }
}
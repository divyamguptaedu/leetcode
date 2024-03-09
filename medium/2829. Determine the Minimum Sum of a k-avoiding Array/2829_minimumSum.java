class Solution {
    public int minimumSum(int n, int k) {
        int[] numbers = new int[n];
        int halfK = k / 2;
        int sum = 0;
        
        if (halfK > n) {
            for (int i = 0; i < n; i++) {
                numbers[i] = i + 1;
                sum += numbers[i];
            }
        } else {
            for (int i = 0; i < halfK; i++) {
                numbers[i] = i + 1;
                sum += numbers[i];
            }
            for (int j = halfK; j < n; j++) {
                numbers[j] = k++;
                sum += numbers[j];
            }
        }
        return sum;     
    }
}

class Solution {
    public int maxCoins(int[] nums) {
        int size = nums.length;
        int array[] = new int[size + 2];
        array[0] = array[size + 1] = 1;
        for (int i = 1; i <= size; i++) {
            array[i] = nums[i - 1];
        }
        int result[][] = new int[size + 2][size + 2];
        for (int slot = 1; slot <= size; slot++) {
            for (int left = 1; left <= size - slot + 1; left++) {
                int right = left + slot - 1;
                for (int i = left; i <= right; i++) { 
                    result[left][right] = Math.max(result[left][right], (arr[left - 1] * arr[i] * arr[right + 1]) + result[left][i - 1] + result[i + 1][right]);
                }
            }
        }
        return result[1][size];
    }
}

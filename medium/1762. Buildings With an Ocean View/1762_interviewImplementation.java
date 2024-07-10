import java.util.Arrays;

class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        int index = n - 1;
        int max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                result[index--] = i;
            }
        }

        return Arrays.copyOfRange(result, index + 1, n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] heights1 = {4, 2, 3, 1};
        int[] result1 = solution.findBuildings(heights1);
        System.out.println("Buildings with ocean view (Test 1): " + Arrays.toString(result1));
        
        int[] heights2 = {4, 3, 2, 1};
        int[] result2 = solution.findBuildings(heights2);
        System.out.println("Buildings with ocean view (Test 2): " + Arrays.toString(result2));
        
        int[] heights3 = {1, 3, 2, 4};
        int[] result3 = solution.findBuildings(heights3);
        System.out.println("Buildings with ocean view (Test 3): " + Arrays.toString(result3));
        
        int[] heights4 = {2, 2, 2, 2};
        int[] result4 = solution.findBuildings(heights4);
        System.out.println("Buildings with ocean view (Test 4): " + Arrays.toString(result4));
    }
}

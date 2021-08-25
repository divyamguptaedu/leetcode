"
Performance:
Runtime: 1 ms, faster than 100.00% of Java online submissions for Buildings With an Ocean View.
Memory Usage: 55.2 MB, less than 45.83% of Java online submissions for Buildings With an Ocean View.
"

class Solution {
    public int[] findBuildings(int[] heights) {
        boolean[] viewExists = new boolean[heights.length];
        int[] result;
        int resultLength = 0;
        int maxHeight = 0;
        
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                viewExists[i] = true;
                resultLength++;
                maxHeight = heights[i];
            }
        }
        
        result = new int[resultLength];
        int index = 0;
        
        for (int i = 0; i < viewExists.length; i++) {
            if (viewExists[i]) {
                result[index] = i;
                index++;
            }
        }
        return result;
    }
}
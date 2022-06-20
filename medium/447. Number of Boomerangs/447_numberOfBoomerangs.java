"""
Performance:
Runtime: 205 ms, faster than 67.99% of Java online submissions for Number of Boomerangs.
Memory Usage: 117 MB, less than 41.95% of Java online submissions for Number of Boomerangs.
"""

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length <= 1) {
            return 0;
        }
        int size = points.length;
        int result = 0;
        for (int i = 0; i < size; i++) {
            int[] tempOne = points[i];
            Map<Integer, Integer> valueMap = new HashMap<>(size - 1);
            for (int j = 0; j < size; j++) {
                if (i == j) continue;
                int[] tempTwo = points[j];
                int distance = helper(tempOne, tempTwo);
                valueMap.put(distance, valueMap.getOrDefault(distance, 0) + 1);
            }
            for (int count : valueMap.values()) {
                result += count * (count - 1);
            }
        }
        return result;
    }
    
    private int helper(int[] tempOne, int[] tempTwo) {
        int dx = tempOne[0] - tempTwo[0];
        int dy = tempOne[1] - tempTwo[1];
        return (dx * dx) + (dy * dy);
    }
}
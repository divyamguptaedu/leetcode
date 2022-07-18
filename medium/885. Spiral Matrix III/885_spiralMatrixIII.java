"
Performance:
Runtime: 10 ms, faster than 97.54% of Java online submissions for Spiral Matrix III.
Memory Usage: 63.7 MB, less than 65.15% of Java online submissions for Spiral Matrix III.
"

class Solution {
    public int[][] spiralMatrixIII(int N, int M, int r, int c) {
        int[][] result = new int[N * M][2];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int count = 2;
        while (index < result.length) {
            for (int i = 0; i < count / 2; i++) {
                if (r >= 0 && r < N && c >= 0 && c < M) {
                    result[index++] = new int[]{r, c};
                }
                int direction = (count + 2) % 4;
                r += directions[direction][0];
                c += directions[direction][1];
            }
            count++;
        }

        return result;
    }
}
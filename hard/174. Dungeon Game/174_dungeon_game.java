"
Performance:
Runtime: 2 ms, faster than 71.87% of Java online submissions for Dungeon Game.
Memory Usage: 43.8 MB, less than 60.12% of Java online submissions for Dungeon Game.
"

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int x = dungeon.length;
        int y = dungeon[0].length;
        int[][] result = new int[x + 1][y + 1];
        
        for(int i = 0; i <= x; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }
        
        result[x - 1][y] = 1;
        result[x][y - 1] = 1;
        
        for (int i = x - 1; i >= 0; i--) {
            for (int j = y - 1; j >= 0; j--) {
                int temp = Math.min(result[i][j + 1], result[i + 1][j]) - dungeon[i][j];
                if (temp < 1) {
                    temp = 1;
                }
                result[i][j] = temp;
            }
        }
        return result[0][0];
    }
}
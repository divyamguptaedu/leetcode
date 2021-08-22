"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
Memory Usage: 37.4 MB, less than 22.23% of Java online submissions for Spiral Matrix.
"

class Solution {
    boolean[][] visited;
    List<Integer> res;
    
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        
        visited = new boolean[matrix.length][matrix[0].length];
        res = new ArrayList<>();
        helper(0, 0, matrix, false);
        return res;
    }
    
    public void helper(int y, int x, int[][] matrix, boolean goingUp) {
        if (y < 0 || y >= matrix.length || x < 0 || x >= matrix[y].length || visited[y][x]) {
        	return;
        }
        res.add(matrix[y][x]);
        visited[y][x] = true;
        
        if (goingUp) {
            helper(y - 1, x, matrix, true);
        }
        
        helper(y, x + 1, matrix, false);
        helper(y + 1, x, matrix, false);
        helper(y, x - 1, matrix, false);
        helper(y - 1, x, matrix, true);
    }
}
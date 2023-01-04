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

//another way

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            //Top Row
            for (int i = left ; i <= right ; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            //Right Column
            for (int i = top ; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            //Bottom Row
            if (top <= bottom) {
                for (int i = right; i >= left; i --) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            //Left Column
            if (left <= right) {
                for (int i = bottom; i >= top; i --) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
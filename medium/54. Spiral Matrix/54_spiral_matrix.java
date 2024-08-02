//To solve the problem of traversing a matrix in spiral order, 
//I used a directional approach. I defined four possible movement directions 
//(right, down, left, up) and tracked the current direction. 
//I started at the top-left corner of the matrix and marked visited 
//elements with a special value. While traversing, 
//I kept changing the direction when hitting the matrix boundaries or a 
//previously visited cell. I repeated this process until 
//I covered all the elements in the matrix.

//Time: MN
//Space: constant
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int VISITED = 101;
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Four directions that we will move: right, down, left, up.
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        // Initial direction: moving right.
        int currentDirection = 0;
        // The number of times we change the direction.
        int changeDirection = 0;
        // Current place that we are at is (row, col).
        // row is the row index; col is the column index.
        int row = 0;
        int col = 0;
        // Store the first element and mark it as visited.
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        matrix[0][0] = VISITED;
        while (changeDirection < 2) {
            while (row + directions[currentDirection][0] >= 0 &&
                    row + directions[currentDirection][0] < rows &&
                    col + directions[currentDirection][1] >= 0 &&
                    col + directions[currentDirection][1] < columns &&
                    matrix[row + directions[currentDirection][0]][col +
                            directions[currentDirection][1]] != VISITED) {
                // Reset this to 0 since we did not break and change the direction.
                changeDirection = 0;
                // Calculate the next place that we will move to.
                row = row + directions[currentDirection][0];
                col = col + directions[currentDirection][1];
                result.add(matrix[row][col]);
                matrix[row][col] = VISITED;
            }
            // Change our direction.
            currentDirection = (currentDirection + 1) % 4;
            // Increment change_direction because we changed our direction.
            changeDirection++;
        }
        return result;
    }
}

//another solution
class Solution {
    int rows;
    int cols;
    boolean[][] visited;
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.visited = new boolean[rows][cols];
        int index = 0;
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        visited[0][0] = true;
        int count = 1;
        int i = 0;
        int j = 0;
        while (count != rows * cols) {
            while (canMove(i + dirs[index][0], j + dirs[index][1])) {
                i += dirs[index][0];
                j += dirs[index][1];
                result.add(matrix[i][j]);
                visited[i][j] = true;
                count++;
            }
            if (index != 3) {
                index++;
            } else {
                index = 0;
            }
        }
        return result;
    }

    private boolean canMove(int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < cols && !visited[i][j]) {
            return true;
        }
        return false;
    }
}
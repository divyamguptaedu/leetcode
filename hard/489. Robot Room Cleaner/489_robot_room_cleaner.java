"""
Performance:
Runtime: 3 ms, faster than 98.58% of Java online submissions for Robot Room Cleaner.
Memory Usage: 38.7 MB, less than 87.07% of Java online submissions for Robot Room Cleaner.
"""

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    int[][] directions;
    Set<Pair<Integer, Integer>> visited;

    public void cleanRoom(Robot robot) {
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, right, down, left-clockwise
        visited = new HashSet<>(); // DFS visited DS
        dfs(robot, 0, 0, 0); // Start from row 0 col 0 direction 0
    }

    private void dfs(Robot robot, int row, int col, int dir) {
        robot.clean(); // Clean the current cell
        visited.add(new Pair<>(row, col)); // Mark the current cell visited
        for (int i = 0; i < 4; i++) { // Explore 4 different directions
            int newDir = (dir + i) % 4; // Next direction 0,1,2,3
            int newI = row + directions[newDir][0]; // New cell row
            int newJ = col + directions[newDir][1]; // New cell column
            if (!visited.contains(new Pair<>(newI, newJ)) && robot.move()) { // If cell not visited and not blocked
                dfs(robot, newI, newJ, newDir); // Explore the new cell
                // Go back
                robot.turnRight();
                robot.turnRight();
                robot.move();
                // Turn the head to the original direction
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight(); // Explore the next direction-total 4 directions
        }
    }
}
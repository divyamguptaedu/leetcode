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
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; 
        visited = new HashSet<>(); 
        helper(robot, 0, 0, 0); 
    }

    private void helper(Robot robot, int row, int col, int dir) {
        robot.clean();
        visited.add(new Pair<>(row, col)); 
        for (int i = 0; i < 4; i++) {
            int newDir = (dir + i) % 4; 
            int newI = row + directions[newDir][0]; 
            int newJ = col + directions[newDir][1]; 
            if (!visited.contains(new Pair<>(newI, newJ)) && robot.move()) { 
                helper(robot, newI, newJ, newDir); 
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight(); 
        }
    }
}
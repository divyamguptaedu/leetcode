// Approach: I simulate the robot's movements according to the instructions. I track its position and direction after one cycle of instructions. If the robot returns to the origin or is not facing north after one cycle, it is bounded in a circle.

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean isRobotBounded(String I) {
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int di = 0, x = 0, y = 0;
        
        for (int i = 0; i < I.length(); i++) {
            switch (I.charAt(i)) {
                case 'L': 
                    di = (di + 3) % 4; // Turn left
                    break;
                case 'R': 
                    di = (di + 1) % 4; // Turn right
                    break;
                default:
                    x += d[di][0];
                    y += d[di][1];
            }
        }
        
        return (x == 0 && y == 0) || (di != 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String instructions1 = "GGLLGG";
        String instructions2 = "GG";
        String instructions3 = "GL";

        System.out.println("Test case 1: " + solution.isRobotBounded(instructions1)); // Expected true
        System.out.println("Test case 2: " + solution.isRobotBounded(instructions2)); // Expected false
        System.out.println("Test case 3: " + solution.isRobotBounded(instructions3)); // Expected true
    }
}

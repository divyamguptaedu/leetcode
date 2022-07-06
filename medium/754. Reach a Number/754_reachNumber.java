"""
Performance:
Runtime: 2 ms, faster than 65.48% of Java online submissions for Reach a Number.
Memory Usage: 40.3 MB, less than 77.54% of Java online submissions for Reach a Number.
"""

class Solution {
    public int reachNumber(int target) {
        int sum = 0;
        int steps = 0;
        if (target == 0) {
            return 0;
        }
        target = Math.abs(target);
        while (sum < target) {
            sum += steps;
            steps++;
        }
        
        while (((sum - target) % 2 != 0)) {
            sum += steps;
            steps++;
        }
        return steps - 1;

    }
}
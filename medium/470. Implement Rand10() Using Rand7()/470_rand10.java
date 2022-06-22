"""
Performance:
Runtime: 9 ms, faster than 64.62% of Java online submissions for Implement Rand10() Using Rand7().
Memory Usage: 50.8 MB, less than 33.21% of Java online submissions for Implement Rand10() Using Rand7().
"""

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int column = rand7();
        int row = rand7();
        int result = (column) + (row - 1) * 7;
        if (result <= 40) {
            return (result - 1) % 10 + 1;
        } else {
            return rand10();
        }
    }
}
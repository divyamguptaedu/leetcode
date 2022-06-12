"
Performance:
Runtime: 1 ms, faster than 78.18% of Java online submissions for Factorial Trailing Zeroes.
Memory Usage: 41.3 MB, less than 31.60% of Java online submissions for Factorial Trailing Zeroes.
"

class Solution {
    public int trailingZeroes(int n) {
    int result = 0;
    while (n > 0) {
        n /= 5;
        result += n;
    }
    return result;
    }
}
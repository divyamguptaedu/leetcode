//Runtime: 1 ms, faster than 95.83% of Java online submissions for Happy Number.
//Memory Usage: 41.1 MB, less than 59.47% of Java online submissions for Happy Number.

class Solution {
    public boolean isHappy(int n) {
        if (n == 1 || n == 7 || n == 10) {
            return true;
        }
        if (n < 10) {
            return false;
        }
        int temp = 0;
        while (n != 0) {
            temp += (n % 10) * (n % 10);
            n = n / 10;
        }
        return isHappy(temp);
    }
}
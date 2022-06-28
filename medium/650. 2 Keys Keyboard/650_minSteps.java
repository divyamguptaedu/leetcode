"
Performance:
Runtime: 1 ms, faster than 80.81% of Java online submissions for 2 Keys Keyboard.
Memory Usage: 41.2 MB, less than 47.97% of Java online submissions for 2 Keys Keyboard.
"

class Solution {
    public int minSteps(int n) {
        int a = 1;
        int count = 0;
        int result = 0;
        boolean complete = false;
        while (a < n) {
            if (count == 0) {
                count = 1;
                result++;
                continue;
            }
            if (complete) {
                int tempOne = a;
                int tempTwo = a * 2;
                if (n > tempTwo && (n - tempTwo) % tempOne == 0) {
                    count = tempOne;
                    complete = false;
                } else {
                    a += count;
                    complete = true;
                }
            } else {
                a += count;
                complete = true;
            }
            result++;
        }
        return result;
    }
}
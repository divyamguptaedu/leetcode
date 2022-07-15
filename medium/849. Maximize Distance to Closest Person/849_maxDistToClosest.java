"
Performance:
Runtime: 4 ms, faster than 40.96% of Java online submissions for Maximize Distance to Closest Person.
Memory Usage: 49.1 MB, less than 66.78% of Java online submissions for Maximize Distance to Closest Person.
"

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        boolean start;
        if (seats[0] == 0) {
            start = true;
        } else {
            start = false;
        }
        int difference = 0;
        int result = 1;
        for (int i = 1; i < n; i++) {
            difference++;
            if (seats[i] == 1) {
                if (start) {
                    result = Math.max(difference, result);               
                    start = false;
                } else {
                    result = Math.max(difference/2, result);
                }
                difference = 0;
            }
            if (i == n - 1 && seats[n - 1] == 0) { 
                result = Math.max(difference, result);
            }
        }
        return result;
    }
}
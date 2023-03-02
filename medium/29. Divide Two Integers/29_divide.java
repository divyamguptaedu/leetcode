class Solution {
    public int divide(int dividend, int divisor) {
        int i;
        int j;
        int j1;

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
       
        if ((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) {
            j = dividend/divisor;
            return j;
        }
        if (divisor > 0 && dividend > 0) {
            j = dividend / divisor;
            return j;
        }
        if (divisor < 0 && dividend < 0) {   
            j = dividend / divisor;
            if (j == min) {
                return max;
            } else {
                return j;
            }
        }
        return 0;
    }
}
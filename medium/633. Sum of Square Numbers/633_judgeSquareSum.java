class Solution {
    public boolean judgeSquareSum(int c) {
        long root = (long) Math.sqrt(c);
        long low = 0;
        long high = root;

        while (low <= high) {
            long sum = (low * low) + (high * high);
            if (sum == (long) c) {
                return true;
            }
            if (sum > (long) c) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }
}
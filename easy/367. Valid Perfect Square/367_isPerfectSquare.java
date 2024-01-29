class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        if (num == 1) {
            return true;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double val = (num * 1.0) / (mid * 1.0);
            if (mid == val) {
                return true;
            } else if (mid < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
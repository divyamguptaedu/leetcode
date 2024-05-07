//We can just solve this question using a binary search approach. We start from left == 2 and right == num/2.
//Then we just calculate mid, check if mid*mid == num, if yes, return true.
//If not, then check mid*mid > num, then right = mid - 1.
//Else left = mid + 1.
//Time: O(logn)
//Space: O(1)
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2;
        long right = num / 2;
        long guessSquared;
        while (left <= right) {
            long mid = (left + right) / 2;
            guessSquared = mid * mid;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
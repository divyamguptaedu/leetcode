//We can solve this question using binary search approach. We need a range. We know that the minimum value of a or b can be 0, 
// and maximum value can be sqrt(c). So, thats our range. We set that as left and right, and do binary search to find the sum.
//If the sum is < c, then left++, if not, right--.
//Time: O(log sqrt(c))
//Space: O(1)
class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        long left = 0;
        long right = (int) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
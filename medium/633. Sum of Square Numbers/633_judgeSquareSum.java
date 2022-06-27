"""
Performance:
Runtime: 7 ms, faster than 50.65% of Java online submissions for Sum of Square Numbers.
Memory Usage: 41 MB, less than 50.85% of Java online submissions for Sum of Square Numbers.
"""

class Solution {
    public boolean judgeSquareSum(int c) {
          long temp = c;
          long left = 0 ;
          long right = (long) Math.sqrt(c);
          long sum = 0 ;
          while (left <= right) {
              sum = left * left + right * right;
              if (sum == temp) {
                return true;
              } else if (sum > temp) {
                right--;
              } else if (sum < temp) {
                left++;
              }
          }
          return false ;
    }
}
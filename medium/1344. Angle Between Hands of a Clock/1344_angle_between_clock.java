"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Angle Between Hands of a Clock.
Memory Usage: 36.1 MB, less than 75.31% of Java online submissions for Angle Between Hands of a Clock.
"""

class Solution {
    public double angleClock(int hour, int minutes) {

        double min = 6.0 * minutes;
        double hr = 30.0 * (hour % 12) + 0.5 * minutes;
       
        return Math.min(360.0 - Math.abs(min - hr), Math.abs(min - hr));
        
    }
}
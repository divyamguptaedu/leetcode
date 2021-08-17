class Solution {
    public double angleClock(int hour, int minutes) {
    	
        double min = 6.0 * minutes;
        double hr = 30.0 * (hour % 12) + 0.5 * minutes;
       
        return Math.min(360.0 - Math.abs(min - hr), Math.abs(min - hr));
        
    }
}
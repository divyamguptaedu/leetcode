class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x = 0;
        int y = 0;
        
        if (y2 >= yCenter && y1 <= yCenter) {
            y = 0;
        } else {
            y = Math.min(Math.abs(y2 - yCenter), Math.abs(y1 - yCenter));
        }

        if (x2 >= xCenter && x1 <= xCenter) {
            x = 0;
        } else {
            y = Math.min(Math.abs(x2 - xCenter), Math.abs(x1 - xCenter));
        }

        if (x * x + y * y <= radius * radius) {
            return true;
        }

        return false;
    }
}
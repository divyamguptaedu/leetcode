"
Performance:
Runtime: 5 ms, faster than 26.03% of Java online submissions for Rectangle Area.
Memory Usage: 42.4 MB, less than 72.09% of Java online submissions for Rectangle Area.
"

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {     
        int firstRectangle = Math.abs((ax2 - ax1) * (ay2 - ay1));
        int secondRectangle = Math.abs((bx2 - bx1) * (by2 - by1));
        int commonAreaOne = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        if (commonAreaOne < 0) {
            commonAreaOne = 0;
        }
        int commonAreaTwo = Math.min(ay2, by2) - Math.max(ay1, by1);
        if (commonAreaTwo < 0) {
            commonAreaTwo = 0;
        }        
        return firstRectangle + secondRectangle - commonAreaOne * commonAreaTwo;      
    }
    
}
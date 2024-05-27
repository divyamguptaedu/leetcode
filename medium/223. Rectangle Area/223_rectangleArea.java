class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
        int areaB = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);

        int intersectionWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int intersectionHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int intersectionArea = intersectionWidth * intersectionHeight;

        return areaA + areaB - intersectionArea;
    }
}
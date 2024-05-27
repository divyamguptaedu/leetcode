//To find the total area covered by two rectangles, 
//I calculated the area of each rectangle separately using their coordinates. 
//I then determined the intersection area by computing the overlap in both width and height between the two rectangles. 
//If there was no overlap, the intersection area was zero. 
//Finally, I summed the areas of both rectangles and 
//subtracted the intersection area to avoid double-counting the overlapping region.

//Time: O(1)
//Space: O(1)
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Calculate the area of the first rectangle
        int areaA = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
        // Calculate the area of the second rectangle
        int areaB = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        // Calculate the width of the intersection rectangle
        int intersectionWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        // Calculate the height of the intersection rectangle
        int intersectionHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        // Calculate the area of the intersection rectangle
        int intersectionArea = intersectionWidth * intersectionHeight;
        // Return the total area covered by the two rectangles minus the intersection area
        return areaA + areaB - intersectionArea;
    }
}
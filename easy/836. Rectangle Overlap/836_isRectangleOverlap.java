//I approached the problem of determining whether two rectangles overlap by first checking if either rectangle is 
//degenerate (essentially a line) because such shapes cannot overlap positively. If either rectangle is a line 
//(checked by comparing x or y coordinates), I immediately return false.
//For non-degenerate rectangles, I used conditions that check for non-overlapping scenarios: if rec1 is to the left of 
//rec2, below rec2, to the right of rec2, or above rec2. If none of these conditions are true, then the rectangles must 
//overlap.
//Time: constant
//Space: constant
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // check if either rectangle is actually a line
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] ||
                rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            // the line cannot have positive overlap
            return false;
        }

        return !(rec1[2] <= rec2[0] || // left
                rec1[3] <= rec2[1] || // bottom
                rec1[0] >= rec2[2] || // right
                rec1[1] >= rec2[3]); // top
    }
}
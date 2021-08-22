"
Perfomance:
Runtime: 13 ms, faster than 87.52% of Java online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.
Memory Usage: 48.7 MB, less than 87.57% of Java online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.
"

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int hLength = horizontalCuts.length;
        int vLength = verticalCuts.length;
                
        int maxHeight = Math.max(horizontalCuts[0]-0, h - horizontalCuts[hLength-1]);
        for (int i = 1;i<hLength; i++){
            int diff = horizontalCuts[i] - horizontalCuts[i-1];
            maxHeight = Math.max(maxHeight, diff);
        }
        
        
        int maxWidth = Math.max(verticalCuts[0]-0, w - verticalCuts[vLength-1]);
        for (int i = 1;i<vLength; i++){
            int diff = verticalCuts[i] - verticalCuts[i-1];
            maxWidth = Math.max(maxWidth, diff);
        }
        
        long ans = 1L * maxHeight * maxWidth;
        
        return  (int) (ans % 1000000007);
    }
}
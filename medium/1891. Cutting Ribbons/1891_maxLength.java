class Solution {
    public int maxLength(int[] ribbons, int k) {      
        int n = ribbons.length;
        int start = 1;
        int end = 0;

        for (int ribbon : ribbons) {
            end = Math.max(end, ribbon);
        }

        int ribbonSegmentCutMaxLength = 0;

        while (end >= start) {
            int mid = start + (end - start) / 2;
            int ribbonSegmnetCut = 0;
            for (int ribbon : ribbons){
                ribbonSegmnetCut += (ribbon / mid);
            }
            if (ribbonSegmnetCut >= k){
                ribbonSegmentCutMaxLength = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ribbonSegmentCutMaxLength;
    }
}
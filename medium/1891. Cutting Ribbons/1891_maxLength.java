//We can solve this question using binary search approach. The minimum length of the cut can be 1 and the max can be the max number in ribbons. 
//Once we have the range, we get the mid value, use it as a proposed cut value. We check how man segments can we make with this mid value,
//if it is >= k then we save it, and chose the right half. Otherwise, left half. We update the result if we find a higher number.

//Time: O(nlogn)
//Space: O(1)
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
            int mid = (start + end) / 2;
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
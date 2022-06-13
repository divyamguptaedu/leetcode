"
Performance: 
Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index II.
Memory Usage: 49.3 MB, less than 85.12% of Java online submissions for H-Index II.
"

class Solution {
    public int hIndex(int[] citations) {
        int size = citations.length;
        int low = 0;
        int high = size;
        while (low < high) {
            int mid = (low + high + 1) >> 1;
            if (citations[n - mid] >= mid) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
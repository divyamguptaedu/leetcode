"
Performance: 
Runtime: 3 ms, faster than 41.64% of Java online submissions for H-Index.
Memory Usage: 41.1 MB, less than 73.79% of Java online submissions for H-Index.
"

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 1;
        while (result <= citations.length) {
            if (citations[citations.length - result] < result) {
                break;
            }
            result++;
        }
        return result - 1;
    }
}
"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Max Chunks To Make Sorted.
Memory Usage: 41.3 MB, less than 57.52% of Java online submissions for Max Chunks To Make Sorted.
"

class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr[arr.length - 1] == 0) {
            return 1;
        }
        int result = 0;
        int maximum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            maximum = Math.max(maximum, arr[i]);
            if (maximum == i){
                result++;
            }
        }
        return result;
        
    }
}
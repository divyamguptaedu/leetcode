"
Performance:
Runtime: 3 ms, faster than 92.19% of Java online submissions for Partition Array into Disjoint Intervals.
Memory Usage: 87.3 MB, less than 76.57% of Java online submissions for Partition Array into Disjoint Intervals.
"

class Solution {
    public int partitionDisjoint(int[] arr) {
        int size = arr.length;
        int maximum = arr[0];
        int temp = arr[0];
        int length = 0;
        
        for (int i = 1; i < size; i++) {
            if (maximum > arr[i]) {
                length = i;
                maximum = temp;
            } else {
                temp = Math.max(temp, arr[i]);
            }
        }
        
        return length + 1;
    }
}
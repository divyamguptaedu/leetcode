"""
Performance:
Runtime: 133 ms, faster than 12.98% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
Memory Usage: 95.6 MB, less than 75.64% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
"""

class Solution {
    public int findMinArrowShots(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int result = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i ++) {
            if (result == 0 || arr[i][0] > temp) {
                result++;
                temp = arr[i][1];
            }
        }
        return result;
    }
}
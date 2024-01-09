"""
Performance:
Runtime: 0 ms, faster than 100% of Java online submissions for Meeting Rooms.
Memory Usage: 45.1 MB, less than 25.54% of Java online submissions for Meeting Rooms.

"""

class Solution {
    public int missingNumber(int[]nums) {
        int n = nums.length;
        int idealSum = (n*(n+1))/2;
        int realSum = 0;
        for (int element: nums) {
            realSum += element;
        }
        return (int)(idealSum-realSum);
    }
}
"""
Performance:
Runtime: 4 ms, faster than 100.00% of Java online submissions for Total Hamming Distance.
Memory Usage: 42.6 MB, less than 98.35% of Java online submissions for Total Hamming Distance.
"""

class Solution {
    public int totalHammingDistance(int[] nums) {
        int size = nums.length;
        int result = 0;
        for (int i = 0 ; i < 32 ; i++) {
            int temp = 0;
            for (int j = 0 ; j < size ; j++) {
                temp += nums[j]>>i&1;
            }
            result += temp * (size - temp);
        }
        
        return result;
    }
}
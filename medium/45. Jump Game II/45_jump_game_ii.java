"""
Performance:
Runtime: 1 ms, faster than 99.31% of Java online submissions for Jump Game II.
Memory Usage: 40 MB, less than 26.40% of Java online submissions for Jump Game II.
"""

class Solution {

	// computed the minimum number of steps;
	public int jump(int[] nums) {
	    int end = 0;
	    int result = 0;
	    int i = 0;
	    while (i < nums.length && end < nums.length - 1) {
	        int max = 0;
	        while (i <= end) {
	            max = Math.max(max, nums[i] + i);
	            i++;
	        }
	        end = max;
	        result++;
	    }
	    return result;
	}
	
}
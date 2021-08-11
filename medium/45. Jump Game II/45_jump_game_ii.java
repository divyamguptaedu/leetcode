class Solution {

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
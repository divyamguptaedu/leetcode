"""
Performance:
Runtime: 2 ms, faster than 72.04% of Java online submissions for Jump Game.
Memory Usage: 40.3 MB, less than 24.58% of Java online submissions for Jump Game.
"""

class Solution {

	public boolean canJump(int[] nums) {
		// keep jumping.
	    int maximum = 0;
	    for (int i = 0; i < nums.length; i++) {
	    	// return false if you are beyond i;
	        if (i > maximum) {
	        	return false;
	        }
	        maximum = Math.max(maximum, i + nums[i]);
	    }
	    // else return true;
	    return true;
	}
	
}
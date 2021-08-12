"""
Performance:
Runtime: 91 ms, faster than 6.83% of Java online submissions for Maximum Product Subarray.
Memory Usage: 38.7 MB, less than 62.02% of Java online submissions for Maximum Product Subarray.
"""

class Solution {

    // iterate over the array and choose the maximum product;
    public int maxProduct(int[] nums) {
    	int product = nums[0];
        for (int i = 0; i < nums.length; i++) {
        	int temp = nums[i];
        	product = Math.max(product, temp);
        	for (int j = i + 1; j < nums.length; j++) {
        		temp = temp * nums[j];
        		product = Math.max(product, temp);
        	}
        }
        return product;
    }
}
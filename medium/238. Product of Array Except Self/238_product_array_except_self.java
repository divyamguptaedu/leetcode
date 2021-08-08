"""
Performance:
Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
Memory Usage: 52.3 MB, less than 27.93% of Java online submissions for Product of Array Except Self.
"""

class Solution {
    public int[] productExceptSelf(int[] nums) {
       	int[] productFromLeft = new int[nums.length];
       	int oldProduct = 1;
       	for (int i = 0; i < nums.length; i++) {
       		productFromLeft[i] = nums[i] * oldProduct;
       		oldProduct = productFromLeft[i];
       	}

       	int[] productFromRight = new int[nums.length];
       	oldProduct = 1;
       	for (int i = nums.length - 1; i >= 0; i--) {
       		productFromRight[i] = nums[i] * oldProduct;
       		oldProduct = productFromRight[i];
       	}

       	int[] result = new int[nums.length];

       	for (int i = 0; i < nums.length; i++) {
       		if (i == 0) {
       			result[i] = productFromRight[i + 1];
       		} else if (i == nums.length - 1) {
       			result[i] = productFromLeft[i - 1];
       		} else {
       			result[i] = productFromLeft[i - 1] * productFromRight[i + 1];
       		}
       	}
       	return result;
    }
}
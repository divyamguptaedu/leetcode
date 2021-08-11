class Solution {
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
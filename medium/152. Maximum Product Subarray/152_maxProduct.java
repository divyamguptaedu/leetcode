//I approached this problem by iterating through the array, maintaining two variables 
//to track the product of subarrays from the left and right ends. 
//For each element, I updated the left and right products by multiplying them with 
//the current element. If any product became zero, I reset it to one, ensuring 
//that the product of the subarray remains unaffected. 
//Then, I compared the maximum product found so far with the current left and right products
//updating the answer accordingly. By considering both prefix and suffix products, I identified the subarray with the largest product efficiently.
//Time: O(n)
//Space: O(1)class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int l = 1;
        int r = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {

            // if any of l or r become 0 then update it to 1
            if (l == 0) {
                l = 1;
            }
            if (r == 0) {
                r = 1
            }

            l *= nums[i]; // prefix product
            r *= nums[n - 1 - i]; // suffix product

            ans = Math.max(ans, Math.max(l, r));

        }

        return ans;

    }
}
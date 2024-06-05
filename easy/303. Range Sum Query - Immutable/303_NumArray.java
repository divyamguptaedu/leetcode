//To solve the problem, I used a prefix sum array. 
//First, I initialized the prefix sum array with an extra element to handle the sum
//calculation efficiently. I filled the prefix sum array by adding the current element
//of the input array to the previous sum. 
//For the sumRange method, I simply subtracted the prefix sum at the start index from 
//the prefix sum at the end index plus one.

//Time: Constructor takes n time, sumRange takes constant.
//Space: O(n)
class NumArray {
    int[] sum; // Prefix sum array

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1]; // Initialize prefix sum array
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i]; // Compute prefix sums
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i]; // Calculate range sum using prefix sums
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

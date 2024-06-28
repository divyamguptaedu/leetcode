//I approached the problem by first sorting the array. 
//I then used a nested loop to fix two sides of the triangle and looked 
//for the third side using a two-pointer technique. 
//For each pair of sides, I found the longest side that 
//could form a valid triangle and counted all the valid 
//triangles that could be formed with those sides. 
//This way, I efficiently counted all possible valid triangles in the array.
//Time: n^2
//Space: logn
class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }
}
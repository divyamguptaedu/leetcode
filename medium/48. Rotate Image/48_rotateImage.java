//I rotate the image by performing two transformations in-place. 
//First, I transpose the matrix by swapping elements across the diagonal. 
//Then, I reverse each row to complete the rotation. 
//The transposition swaps each element nums[i][j] with nums[j][i], 
//effectively rotating the matrix by 90 degrees. 
//Reversing each row horizontally ensures the clockwise rotation. 
//This approach modifies the input matrix directly, 
//fulfilling the in-place rotation requirement without using additional memory allocation.

//Time: O(n^2)
//Space: O(1)
class Solution {
    public void rotate(int[][] nums) {
        // Transpose the matrix
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length / 2; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[i][nums.length - 1 - j];
                nums[i][nums.length - 1 - j] = temp;
            }
        }
    }
}

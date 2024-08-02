//I iterated through each element of the first matrix. 
//If an element in the first matrix was non-zero, 
//I multiplied it with the corresponding row elements of the second matrix and 
//accumulated the results in the product matrix. 
//This way, I only performed necessary multiplications, 
//reducing the number of operations for sparse matrices.

//Time: n*k*m
//Space: constant, result doesn't count
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int rowsMat1 = mat1.length; // number of rows in mat1
        int colsMat1 = mat1[0].length; // number of columns in mat1
        int colsMat2 = mat2[0].length; // number of columns in mat2

        // Result matrix will have dimensions 'rowsMat1 x colsMat2'.
        int[][] result = new int[rowsMat1][colsMat2];

        for (int rowIndex = 0; rowIndex < rowsMat1; ++rowIndex) {
            for (int elementIndex = 0; elementIndex < colsMat1; ++elementIndex) {
                // If current element of mat1 is non-zero, multiply with the corresponding elements of mat2.
                if (mat1[rowIndex][elementIndex] != 0) {
                    for (int colIndex = 0; colIndex < colsMat2; ++colIndex) {
                        result[rowIndex][colIndex] += mat1[rowIndex][elementIndex] * mat2[elementIndex][colIndex];
                    }
                }
            }
        }

        return result;
    }
}

//another solution
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int rows2 = mat2.length;
        int cols2 = mat2[0].length;

        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                if (mat1[i][j] != 0) {
                    for (int k = 0; k < cols2; k++) {
                        result[i][k] += mat1[i][j] * mat2[j][k];
                    }
                }
            }
        }
        return result;
    }
}
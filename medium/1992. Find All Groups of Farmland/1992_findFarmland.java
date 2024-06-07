//I iterated through each cell in the matrix, checking if it was farmland (1).
//When I found farmland, I marked the top-left corner. 
//Then, I expanded right and down to find the bottom-right corner of this farmland 
//group while marking all cells within this group as forest (0) to avoid recounting them. 
//I collected the coordinates of the top-left and bottom-right corners for each group. 
//This ensured each farmland group was identified and marked, 
//and no adjacent groups were processed together.

//Time: mn
//Space: 1
class Solution {
    public int[][] findFarmland(int[][] land) {
        int numRows = land.length;
        int numCols = land[0].length; // Initialize the number of rows and columns
        List<int[]> farmlandGroups = new ArrayList<>(); // List to store the coordinates of farmland groups

        for (int row = 0; row < numRows; row++) { // Iterate through each row
            for (int col = 0; col < numCols; col++) { // Iterate through each column
                if (land[row][col] == 1) { // Check if the current cell is farmland
                    int endRow = row;
                    int endCol = col; // Initialize endRow and endCol to current cell coordinates

                    // Expand downwards to find the bottom edge of the farmland group
                    for (endRow = row; endRow < numRows && land[endRow][col] == 1; endRow++) {
                        // Expand rightwards to find the right edge of the farmland group
                        for (endCol = col; endCol < numCols && land[endRow][endCol] == 1; endCol++) {
                            land[endRow][endCol] = 0; // Mark the cell as visited by setting it to 0
                        }
                    }

                    // Save the top-left and bottom-right corners of the farmland group
                    int[] farmlandGroup = new int[] { row, col, endRow - 1, endCol - 1 };
                    farmlandGroups.add(farmlandGroup); // Add the farmland group to the list
                }
            }
        }
        return farmlandGroups.stream().toArray(int[][]::new); // Convert the list to a 2D array and return it
    }
}

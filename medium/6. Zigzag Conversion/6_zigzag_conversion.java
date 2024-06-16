//Two ways to solve this question. Listed both.

//I chose to simulate the zigzag pattern directly using a character matrix, 
//which I then traversed to construct the final string in the desired zigzag order. 
//The approach involved calculating the necessary dimensions of the matrix based on the number 
//of rows and the pattern of movement.
//First, I determined the number of columns required to accommodate the zigzag pattern, 
//given the constraints on the movement between rows. Using this matrix, 
//I iteratively filled it by moving characters downwards and diagonally upwards, 
//simulating the zigzag pattern as described. 
//Finally, I collected characters from the matrix row by row, skipping the spaces, 
//to form the resultant string.

//Time: numRows * n
//Space: numRows * n
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        int sections = (int) Math.ceil(n / (2 * numRows - 2.0));
        int numCols = sections * (numRows - 1);

        char[][] matrix = new char[numRows][numCols];
        for (char[] row : matrix) {
            Arrays.fill(row, ' ');
        }

        int currRow = 0, currCol = 0;
        int currStringIndex = 0;

        // Iterate in zig-zag pattern on matrix and fill it with string characters.
        while (currStringIndex < n) {
            // Move down.
            while (currRow < numRows && currStringIndex < n) {
                matrix[currRow][currCol] = s.charAt(currStringIndex);
                currRow++;
                currStringIndex++;
            }

            currRow -= 2;
            currCol++;

            // Move up (with moving right also).
            while (currRow > 0 && currCol < numCols && currStringIndex < n) {
                matrix[currRow][currCol] = s.charAt(currStringIndex);
                currRow--;
                currCol++;
                currStringIndex++;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (char[] row : matrix) {
            for (char character : row) {
                if (character != ' ') {
                    answer.append(character);
                }
            }
        }

        return answer.toString();
    }
}

//In solving the Zigzag Conversion problem, I utilized a strategic approach to directly compute 
//the output string without using extra space for a matrix representation. 
//The key insight was recognizing the pattern of jumps between characters in each row of the 
//zigzag pattern. By iterating through each row and calculating these jumps dynamically, 
//I efficiently constructed the result string row by row.
//I initialized a StringBuilder to accumulate the characters in the zigzag order. 
//For each row, starting from the top to the bottom of the zigzag, 
//I determined the positions of characters based on the row index and the defined pattern of jumps. 
//Characters were appended directly to the StringBuilder in the correct order without 
//pre-allocating additional space.

//Time: n
//Space: constant
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder answer = new StringBuilder();
        int n = s.length();
        int charsInSection = 2 * (numRows - 1);

        for (int currRow = 0; currRow < numRows; ++currRow) {
            int index = currRow;

            while (index < n) {
                answer.append(s.charAt(index));

                // If currRow is not the first or last row
                // then we have to add one more character of current section.
                if (currRow != 0 && currRow != numRows - 1) {
                    int charsInBetween = charsInSection - 2 * currRow;
                    int secondIndex = index + charsInBetween;

                    if (secondIndex < n) {
                        answer.append(s.charAt(secondIndex));
                    }
                }
                // Jump to same row's first character of next section.
                index += charsInSection;
            }
        }

        return answer.toString();
    }
}
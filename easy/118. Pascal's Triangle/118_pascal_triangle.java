//Constructed Pascal's triangle up to numRows using a nested loop. 
//It initializes the triangle with the base case of [1]. 
//Then, for each subsequent row, it calculates the values based on the previous row, summing adjacent elements. 
//The algorithm efficiently builds the triangle row by row, adding each row to the result list. 
//Finally, it returns the generated Pascal's triangle. 

//Time: O(numRows^2)
//Space: O(1)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // Base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}
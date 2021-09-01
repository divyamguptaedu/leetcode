"
Performance:
Runtime: 25 ms, faster than 58.11% of Java online submissions for Subrectangle Queries.
Memory Usage: 42.8 MB, less than 47.59% of Java online submissions for Subrectangle Queries.
"

class SubrectangleQueries {

    private int[][] rectangle;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for(int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
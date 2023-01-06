class Solution {
    public boolean isValidSudoku(char[][] board) {

        List<Set<Character>> rowValues = new ArrayList<>();
        List<Set<Character>> colValues = new ArrayList<>();
        List<Set<Character>> gridValues = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rowValues.add(new HashSet<>());
            colValues.add(new HashSet<>());
            gridValues.add(new HashSet<>());
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                
                int gridIndex = (r/3) * 3 + (c/3);
                char cellValue = board[r][c];

                if (rowValues.get(r).contains(cellValue) || colValues.get(c).contains(cellValue) || gridValues.get(gridIndex).contains(cellValue)) {
                    return false;
                }
                rowValues.get(r).add(cellValue);
                colValues.get(c).add(cellValue);
                gridValues.get(gridIndex).add(cellValue);
            }
        }

        return true;
    }
}
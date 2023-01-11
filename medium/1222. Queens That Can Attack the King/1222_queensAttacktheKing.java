class Solution {

    int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {1, -1}, {-1, 1}, {0, -1}, {-1, 0}, {-1, -1}};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] board = new int[8][8];

        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = 1;
        }

        for (int[] direction : directions) {
            int kingX = king[0];
            int kingY = king[1];

            while (kingX >= 0 && kingX < 8 && kingY >= 0 && kingY < 8 && board[kingX][kingY] == 0) {
                kingX += direction[0];
                kingY += direction[1];
            }
            if (kingX >= 0 && kingX < 8 && kingY >= 0 && kingY < 8) {
                result.add(new ArrayList<>(Arrays.asList(new Integer[]{kingX, kingY})));
            }
        }

        return result;

    
    }
}
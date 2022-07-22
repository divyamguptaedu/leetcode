"
Performance:
Runtime: 6 ms, faster than 91.90% of Java online submissions for Snakes and Ladders.
Memory Usage: 46.9 MB, less than 73.49% of Java online submissions for Snakes and Ladders.
"

class Solution {
    public int snakesAndLadders(int[][] board) {
        int size = board.length;
        int index = 1;
        int array[] = new int[size * size + 1];
        int temp = 0;
        if (size % 2 == 0) {
            temp = 1;
        }

        for (int i = size - 1; i >= 0 ; i--) {
           if (i % 2 == temp) {
               for (int j = 0 ; j < size;  j++) {
                   array[index] = board[i][j];
                   index++;
               }
           } else {
               for (int j = size - 1; j >= 0; j--) {
                   array[index] = board[i][j];
                   index++;
               }
           }
       }

        return helper(array);
    }

    public int helper(int[] array) {
        int steps = 0;
        int size = array.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[size + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {
            int temp = queue.size();
            while (temp --> 0) {
                int curr = queue.poll();
                if (curr == size - 1) {
                    return (steps);
                }
                for (int i = curr + 1; i <= curr + 6 && i < array.length; i++) {
                    if (!visited[i]) {
                        visited[i] = true;
                        int done = array[i] == -1 ? i : array[i];
                        queue.add(done);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
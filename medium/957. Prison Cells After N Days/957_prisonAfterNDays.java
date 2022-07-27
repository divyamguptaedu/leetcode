"
Performance:
Runtime: 6 ms, faster than 89.69% of Java online submissions for Prison Cells After N Days.
Memory Usage: 43.4 MB, less than 52.79% of Java online submissions for Prison Cells After N Days.
"

class Solution {
    
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] first = helper(cells);
        N--;
        cells = first.clone(); 
        int counter = 1;
        while (N-- > 0) {
            int[] next = helper(cells);
            if (Arrays.equals(first, next)) {
                N = N % counter;
            }
            cells = next.clone();
            counter++;
        }
        return cells;
    }
    
    private int[] helper(int[] cells) {
        int[] answer = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                answer[i] = 1;
            }
        }
        return answer;
    }
}
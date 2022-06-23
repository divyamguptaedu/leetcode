"
Performance:
Runtime: 46 ms, faster than 50.42% of Java online submissions for Random Flip Matrix.
Memory Usage: 50.4 MB, less than 75.63% of Java online submissions for Random Flip Matrix.
"

class Solution {
    int rows;
    int columns;
    int total;
    Random random;
    Set<Integer> result;
    public Solution(int n_rows, int n_cols) {
        this.rows = n_rows;
        this.columns = n_cols;
        this.random = new Random();
        this.result = new HashSet<>();
        this.total = this.rows * this.columns;
    }
    public int[] flip() {
        int temp = random.nextInt(this.total);
        while (result.contains(temp)) {
            temp = random.nextInt(this.total);
        }
        this.result.add(temp);
        return new int[]{temp / this.columns, temp % this.columns};
    }
    
    public void reset() {
        this.result.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
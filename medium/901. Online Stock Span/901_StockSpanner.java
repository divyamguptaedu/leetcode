"
Performance:
Runtime: 62 ms, faster than 57.98% of Java online submissions for Online Stock Span.
Memory Usage: 75.1 MB, less than 24.68% of Java online submissions for Online Stock Span.
"

class StockSpanner {
    Stack<int[]> stack;
    int index = 0;
    public StockSpanner() {
        stack = new Stack<>(); 
        stack.push(new int[] {1000000, -1});
    }
    
    public int next(int price) {
        while (stack.size() > 0 && stack.peek()[0] <= price) {
            stack.pop();
        }
        int result = index - stack.peek()[1];
        stack.push(new int[]{ price, index++});
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
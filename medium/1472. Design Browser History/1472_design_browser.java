/*
1. Use hashmap with int key and string value.
2. Put 0 initially.
3. Keep increasing key as more visited.
4. Subtract from current when back is called.
5. Add to current when forward is called.
*/

class BrowserHistory {
    int current = 0;
    int maximum = 0;
    HashMap<Integer, String> valueMap = new HashMap<>();
    
    public BrowserHistory(String homepage) {
        valueMap.put(current, homepage);
    }
    
    public void visit(String url) {
        current++;
        valueMap.put(current, url);
        maximum = current;
    }
    
    public String back(int steps) {
        current = Math.max(0, current - steps);
        return valueMap.get(current);
    }
    
    public String forward(int steps) {
        current = Math.min(maximum, current + steps);
        return valueMap.get(current);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
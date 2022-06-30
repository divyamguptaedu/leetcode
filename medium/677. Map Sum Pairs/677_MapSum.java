"
Performance:
Runtime: 17 ms, faster than 72.66% of Java online submissions for Map Sum Pairs.
Memory Usage: 43.1 MB, less than 49.08% of Java online submissions for Map Sum Pairs.
"

class MapSum {
    Map<String,Integer> valueMap;
    public MapSum() {
        valueMap = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        valueMap.put(key, val);
    }
    
    public int sum(String prefix) {
        int result = 0;
        for (Map.Entry<String,Integer> entry : valueMap.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                result += entry.getValue();
            }
        }
        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
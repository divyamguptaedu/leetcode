"
Performance:
Runtime: 385 ms, faster than 16.02% of Java online submissions for Stream of Characters.
Memory Usage: 65 MB, less than 98.91% of Java online submissions for Stream of Characters.
"

class StreamChecker {
    Map<Character, List<String>> map;
    int maximum;
    StringBuilder stringBuilder;

    public StreamChecker(String[] words) {
        stringBuilder = new StringBuilder();
        maximum = Integer.MIN_VALUE;
        map = new HashMap<>();
        for (String x : words) {
            char end = x.charAt(x.length() - 1);
            List<String> list = map.getOrDefault(end, new ArrayList<>());
            list.add(x);
            map.put(end, list);
            maximum = Math.max(maximum, x.length());
        }
        
    }
    
    public boolean query(char letter) {
        stringBuilder.append(letter);
        int length = stringBuilder.length();
        if (length > maximum) {
            stringBuilder.delete(0,1);
        }
        if (map.containsKey(letter)) {
            List<String> list = map.get(letter);
            for (String w: list){
                int lengthX = w.length();
                if (stringBuilder.length() < lengthX){
                    continue;
                }
                String stored = stringBuilder.substring(stringBuilder.length() - lengthX, stringBuilder.length()).toString();
                if (stored.equals(w)) {
                    return true;
                }
            }
        }
        return false;
        
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
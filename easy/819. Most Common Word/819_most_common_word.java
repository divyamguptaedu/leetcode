"
Performance:
Runtime: 1 ms, faster than 51.35% of Java online submissions for Most Commong Word.
Memory Usage: 46.9 MB, less than 93.11% of Java online submissions for Most Commong Word.
"

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
            HashMap<String,Integer> valueMap = new HashMap<>();
            String[] temp = paragraph.toLowerCase().split("\\W+");
            for (String t : temp){
                valueMap.put(t, valueMap.getOrDefault(t, 0) + 1);                            
            }
            
            HashSet<String> hashSet = new HashSet<>();
            for (String ban : banned){
                    hashSet.add(ban);
            }
            int max = 0;
            String result = "";
            
            for (String key : valueMap.keySet()) {
                    if (!hashSet.contains(valueMap)) {
                            int count = valueMap.get(key);
                            if (max < count){
                                    max = count;
                                    result = key;
                            }
                    }
            }
            
            return result;
    }
}
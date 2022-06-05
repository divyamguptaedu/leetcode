class Solution {
    public List<String> commonChars(String[] words) {
        List<Map<Character, Integer>> valueMap = new ArrayList<>();
        for (String word : words) {
            Map<Character, Integer> temp = new HashMap<>();
            for (Character char : word.toCharArray())
                temp.put(char, temp.getOrDefault(char, 0) + 1);
            valueMap.add(temp);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : valueMap.get(0).entrySet()) {
            char tempChar = entry.getKey();
            int count = entry.getValue();
            for (int i = 1; i < valueMap.size(); i++) {
                count = Math.min(count, valueMap.get(i).getOrDefault(tempChar, 0));
            }
            for (int i = 0; i < count; i++) {
                result.add(tempChar + "");
            }
        }
        return result;
    }
}
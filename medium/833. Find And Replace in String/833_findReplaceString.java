"
Performance:
Runtime: 4 ms, faster than 96.83% of Java online submissions for Find And Replace in String.
Memory Usage: 43.4 MB, less than 89.30% of Java online submissions for Find And Replace in String.
"

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder result = new StringBuilder();
        HashMap<Integer, String> valueMap = new HashMap<>();
        HashMap<Integer, String> oldMap = new HashMap<>();
        for (int i = 0; i< indices.length; i++) {
            String source = sources[i];
            int current = indices[i];
            String target = targets[i];
            if ((current > s.length()) || (current + source.length() > s.length())) {
                continue;
            }
            if (s.substring(current, current + source.length()).equals(source)) {
                valueMap.put(current, target);
                oldMap.put(current,source);
            }
        }
        for (int i = 0; i < s.length();) {
            if (valueMap.containsKey(i)) {
                result.append(valueMap.get(i));
                i = i + oldMap.get(i).length();
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        return result.toString();
    }
}
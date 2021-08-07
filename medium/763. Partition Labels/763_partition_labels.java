"""
Performance:
Runtime: 5 ms, faster than 45.22% of Java online submissions for Partition Labels.
Memory Usage: 39.1 MB, less than 31.93% of Java online submissions for Partition Labels.
"""

class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> array = new ArrayList<>();

        // create a hashmap with stores the last index of each element/
        HashMap<Character, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            valueMap.put(s.charAt(i), i);
        }
        int start = 0;
        int end = 0;
        int lastIndex;

        // finds the lastIndex of the start and updated end based on elements found in between. 
        for (int i = 0; i < s.length(); i++) {
            lastIndex = valueMap.get(s.charAt(i));
            if (lastIndex > end) {
                end = lastIndex;
            }
            if (i == end) {
                array.add(end - start + 1);
                start = i + 1;
            }
        }
        return array;
    }
}
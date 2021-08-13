"""
Performance:
Runtime: 52 ms, faster than 36.87% of Java online submissions for Longest Consecutive Sequence.
Memory Usage: 61.8 MB, less than 6.42% of Java online submissions for Longest Consecutive Sequence.
"""

public class Solution {

    public int longestConsecutive(int[] num) {
        int longest = 0;
        Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < num.length; i++) {
            // remove duplicates;
            if (valueMap.containsKey(num[i])) {
            	continue;
            }
            // put all uniques in the hashmap;
            valueMap.put(num[i], 1);  
            int start = num[i];
            int end = num[i];
            if(valueMap.containsKey(num[i] + 1))
                end = num[i] + valueMap.get(num[i] + 1);
            if(valueMap.containsKey(num[i] - 1))
                start = num[i] - valueMap.get(num[i] - 1);
            longest = Math.max(longest, end - start + 1);
            valueMap.put(end, end - start + 1);
            valueMap.put(start, end - start + 1);
        }
        // return the longest;
        return longest;
    }
    
}
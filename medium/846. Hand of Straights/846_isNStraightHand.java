"
Performance:
Runtime: 109 ms, faster than 99.89% of Java online submissions for Hand of Straights.
Memory Usage: 56 MB, less than 41.39% of Java online submissions for Hand of Straights.
"

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer,Integer> valueMap = new TreeMap();
        for (int handValue : hand) {
            valueMap.put(handValue, valueMap.getOrDefault(handValue, 0) + 1);
        }
        while (!valueMap.isEmpty()) {
            int next = valueMap.firstKey();
            for (int i = next; i < next + groupSize; i++) {
                if (!helper(valueMap, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean helper(TreeMap<Integer,Integer> valueMap, int index) {
        if (valueMap.get(index) == null) {
            return false;
        } else if (valueMap.get(index) == 1) {
            valueMap.remove(index);
        } else {
            valueMap.put(index, valueMap.get(index) - 1);
        }
        return true;
    }
}
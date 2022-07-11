"
Performance:
Runtime: 2 ms, faster than 85.32% of Java online submissions for Number of Matching Subsequences.
Memory Usage: 90.35 MB, less than 86.85% of Java online submissions for Number of Matching Subsequences.
"

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> valueMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!v.containsKey(s.charAt(i))) {
                valueMap.put(s.charAt(i), new ArrayList<Integer>());
            }
            valueMap.get(s.charAt(i)).add(i);
        }
        int result = 0;
        for (String temp : words) {
            int previous = -1;
            boolean found = false;
            int j = 0;
            outer:
            for (j = 0; j < temp.length(); j++) {
                boolean has = false;
                char c = temp.charAt(j);
                
                if (valueMap.containsKey(c)) {
                    List<Integer> list = valueMap.get(c);
                    for (int i : list) {
                        if (i > previous) {
                            has = true;
                            previous = i;
                        }
                    }
                } else {
                    break outer;
                }
                if (has == false) {
                    break outer;
                } else {
                    found = true;
                }
            }
            if (found == true && j == temp.length()) {
                result++;
            }

        }
        return result;
    }
}
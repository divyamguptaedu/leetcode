"""
Performance:
Runtime: 47 ms, faster than 23.16% of Java online submissions for Repeated DNA Sequences.
Memory Usage: 63.7 MB, less than 49.16% of Java online submissions for Repeated DNA Sequences.
"""

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> temp = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sequence = s.substring(i, i + 10);
            if (temp.contains(sequence)) {
                result.add(sequence);
            } else {
                temp.add(sequence);
            }
        }
        return new ArrayList(result);
    }
}
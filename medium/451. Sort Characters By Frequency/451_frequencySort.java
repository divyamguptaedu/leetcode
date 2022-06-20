"""
Performance:
Runtime: 13 ms, faster than 88.21% of Java online submissions for Sort Characters By Frequency.
Memory Usage: 46.6 MB, less than 74.80% of Java online submissions for Sort Characters By Frequency.
"""

class Solution {
    public String frequencySort(String s) {
        Map<Character, Node> valueMap = new HashMap<>();
        char[] temp = s.toCharArray();
        for (char c : temp) {
            if (valueMap.containsKey(c)) {
                valueMap.get(c).frequency++;
            } else {
                valueMap.put(c, new Node(c, 1));
            }
        }
        PriorityQueue<Node> heap = new PriorityQueue<>((x, y) -> y.frequency - x.frequency);
        for (Node n : valueMap.values()) {
            heap.add(n);
        }
        StringBuilder result = new StringBuilder();
        while (!heap.isEmpty()) {
            Node node = heap.poll();
            while (node.frequency-- > 0) {
                result.append(node.letter);
            }
        }
        return result.toString();
    }
}

class Node {
    char letter;
    int frequency;
    Node(char letter, int frequency) {
        this.letter = letter;
        this.frequency = frequency;
    }
}
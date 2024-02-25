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

//another solution

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (Character c : map.keySet()) {
            if (buckets[map.get(c)] == null) {
                buckets[map.get(c)] = new ArrayList<>();       
            }
            buckets[map.get(c)].add(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (Character c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(c);
                    }
                }
            }
        } 
        return result.toString();   
    }
}
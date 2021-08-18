class AutocompleteSystem {
    Trie root;
    StringBuilder stringBuilder;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        buildTrie(sentences, times);
        stringBuilder = new StringBuilder();
    }

    private void buildTrie(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String s, int count) {
        Trie curr = root;
        for (Character ch : s.toCharArray()) {
            int index = ch == ' ' ? 26 : ch - 'a'; // Handle space
            if (curr.child[index] == null)
                curr.child[index] = new Trie();

            curr = curr.child[index];
            curr.map.put(s, curr.map.getOrDefault(s, 0) + count);
        }
    }

    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if (c == '#') {
            add(stringBuilder.toString(), 1);
            stringBuilder = new StringBuilder();
            return result;
        }
        stringBuilder.append(c);

        Trie curr = root;
        for (Character ch : stringBuilder.toString().toCharArray()) {
            int index = ch == ' ' ? 26 : ch - 'a';
            if (curr.child[index] == null)
                return result;
            curr = curr.child[index];
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() == o2.getValue() ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue());

        for (Map.Entry<String, Integer> entry : curr.map.entrySet()) {
            pq.offer(entry);
        }

        int count = 3;
        while (!pq.isEmpty() && count-- != 0) {
            result.add(pq.poll().getKey());
        }
        return result;
    }

    class Trie {
        Trie child[] = new Trie[27];
        Map<String, Integer> map = new HashMap<>(); // At each trie node, add sentence & counts
    }
}
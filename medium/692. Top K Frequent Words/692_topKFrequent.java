//I started by counting the frequency of each word using a HashMap. 
//Then, I used a PriorityQueue to sort the words by frequency in descending order. 
//For words with the same frequency, I sorted them lexicographically. 
//Finally, I extracted the top k words from the PriorityQueue and 
//added them to the result list.

//Time: nlogn
//Space: n
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Create a map to count the frequency of each word
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        
        // Create a priority queue to sort the words by frequency and lexicographical order
        PriorityQueue<Map.Entry<String, Integer>> sortedWords = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                if (entry2.getValue().equals(entry1.getValue())) {
                    return entry1.getKey().compareTo(entry2.getKey());
                } else {
                    return entry2.getValue() - entry1.getValue();
                }
            }
        });
        
        // Add all entries to the priority queue
        sortedWords.addAll(frequencyMap.entrySet());
        
        // Extract the top k frequent words
        List<String> topKWords = new ArrayList<>();
        for (int i = 0; i < k && !sortedWords.isEmpty(); i++) {
            topKWords.add(sortedWords.poll().getKey());
        }
        
        return topKWords;
    }
}
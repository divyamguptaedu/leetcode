//To solve this question, one approach is to first make a frequency map and then sort the keys based on the values, and then make a string.
//This approach will be nlogn time, however, we can do this question in n time, using bucketsort instead of any other sort. 
//So, we will make the frequency map, get the max frequency, and then make a list of list of chars representing buckets. 
//For every key in the map, we will add that key to the bucket of its frequency. This is essentially sorting in n time.
//Then we will iterate the buckets list of list starting from the end, and build our result string and return.

//Time: O(n)
//Space: O(n)
class Solution {
    public String frequencySort(String s) {

        if (s == null || s.isEmpty()) {
            return s;
        }

        // Count up the occurances.
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int maximumFrequency = Collections.max(counts.values()); //get the max

        // Make the list of buckets and apply bucket sort.
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= maximumFrequency; i++) {
            buckets.add(new ArrayList<Character>());
        }
        for (Character key : counts.keySet()) {
            int freq = counts.get(key);
            buckets.get(freq).add(key);
        }

        // Build up the string.
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.size() - 1; i >= 1; i--) {
            for (Character c : buckets.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
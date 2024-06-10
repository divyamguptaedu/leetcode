//I maintain two data structures: a HashMap to store key-value pairs and
//their corresponding frequencies, and another HashMap to store frequencies mapped
//to sets of keys with the same frequency. Upon a 'get' operation, 
//I update the frequency and reorder the keys accordingly.
//For a 'put' operation, I insert a new key-value pair while ensuring the cache's
//capacity and maintaining the least frequently used key's frequency.
//If the cache reaches its capacity, I remove the least frequently used key.

//Time: constant for all methods
//Space: capacity
class LFUCache {
    // Key: original key, Value: frequency and original value
    Map<Integer, Pair<Integer, Integer>> cache;
    // Key: frequency, Value: Keys with the same frequency
    Map<Integer, LinkedHashSet<Integer>> frequencies;
    // Minimum frequency in the cache
    int minFrequency;
    // Capacity of the cache
    int capacity;

    // Method to insert a new key-value pair with its frequency
    private void insert(int key, int frequency, int value) {
        cache.put(key, new Pair<>(frequency, value));
        frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
        frequencies.get(frequency).add(key);
    }

    // Constructor to initialize the cache with the given capacity
    public LFUCache(int capacity) {
        cache = new HashMap<>();
        frequencies = new HashMap<>();
        minFrequency = 0;
        this.capacity = capacity;
    }

    // Method to get the value of the given key from the cache
    public int get(int key) {
        Pair<Integer, Integer> frequencyAndValue = cache.get(key);
        if (frequencyAndValue == null) {
            return -1;
        }
        int frequency = frequencyAndValue.getKey();
        Set<Integer> keys = frequencies.get(frequency);
        keys.remove(key);
        if (keys.isEmpty()) {
            frequencies.remove(frequency);
            if (minFrequency == frequency) {
                minFrequency++;
            }
        }
        int value = frequencyAndValue.getValue();
        insert(key, frequency + 1, value);
        return value;
    }

    // Method to update or insert a key-value pair into the cache
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        Pair<Integer, Integer> frequencyAndValue = cache.get(key);
        if (frequencyAndValue != null) {
            cache.put(key, new Pair<>(frequencyAndValue.getKey(), value));
            get(key);
            return;
        }
        if (capacity == cache.size()) {
            Set<Integer> keys = frequencies.get(minFrequency);
            int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
            if (keys.isEmpty()) {
                frequencies.remove(minFrequency);
            }
        }
        minFrequency = 1;
        insert(key, 1, value);
    }
}
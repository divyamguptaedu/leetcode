//I used an array of LinkedLists to implement the MyHashMap. 
//I created a fixed number of buckets, each a LinkedList of Entry objects. 
//Each Entry stored a key-value pair. The key's hash code determined the bucket index. 
//To insert a key-value pair, I calculated the index, then searched the LinkedList in that bucket for the key. 
//If found, I updated the value; otherwise, I added a new Entry. 
//For retrieval and deletion, I similarly located the bucket and searched for the key.

//Time: O(n/k) for put, get, and remove. n is the number of entries, and k is the number of buckets. All time complexities are amortized O(1)
//Amortized means that on average it's o(1), but worst case it can be n/k.
//Space: O(n + k)
class MyHashMap {
    private static final int numBuckets = 1000; // Number of buckets
    private LinkedList<Entry>[] buckets; // Array of LinkedLists to store entries

    private static class Entry {
        int key; // Key of the entry
        int value; // Value of the entry
        Entry next; // Pointer to the next entry

        Entry(int key, int value) {
            this.key = key; // Initialize key
            this.value = value; // Initialize value
        }
    }

    public MyHashMap() {
        buckets = new LinkedList[numBuckets]; // Initialize the buckets array
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new LinkedList<>(); // Initialize each bucket as a LinkedList
        }
    }

    public void put(int key, int value) {
        int index = key % numBuckets; // Compute bucket index
        LinkedList<Entry> bucket = buckets[index]; // Get the bucket

        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value; // Update the value if key is found
                return;
            }
        }

        bucket.add(new Entry(key, value)); // Add new entry if key is not found
    }

    public int get(int key) {
        int index = key % numBuckets; // Compute bucket index
        LinkedList<Entry> bucket = buckets[index]; // Get the bucket

        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value; // Return the value if key is found
            }
        }

        return -1; // Return -1 if key is not found
    }

    public void remove(int key) {
        int index = key % numBuckets; // Compute bucket index
        LinkedList<Entry> bucket = buckets[index]; // Get the bucket

        Entry toRemove = null;
        for (Entry entry : bucket) {
            if (entry.key == key) {
                toRemove = entry; // Find the entry to remove
                break;
            }
        }

        if (toRemove != null) {
            bucket.remove(toRemove); // Remove the entry if found
        }
    }
}
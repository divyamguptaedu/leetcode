//To implement a RandomizedCollection that supports duplicates, 
//I used an ArrayList to store the elements and a HashMap to keep track of the indices of each element. 
//When inserting, I added the element to the list and recorded its index in the map. 
//When removing, I replaced the element to be removed with the last element in the list to maintain O(1) time complexity. 
//Finally, for retrieving a random element, I used the Random class to pick a random index from the list.

//Time: O(1) for insert, remove, and getRandom
//Space: O(n)
class RandomizedCollection {
    // List to store elements
    ArrayList<Integer> list = new ArrayList<>();
    // Map to store the indices of each element
    Map<Integer, HashSet<Integer>> locs = new HashMap<>();
    // Random object to generate random numbers
    Random rand = new Random();

    public RandomizedCollection() {
        // Constructor initializes the data structure
    }

    // Inserts an item into the collection. Returns true if the item is not present, false otherwise.
    public boolean insert(int val) {
        // Add value to the list
        int id = list.size();
        list.add(val);
        // Check if value is already present
        boolean present = !locs.containsKey(val);
        // Get the set of indices for the value, or create a new set if not present
        HashSet<Integer> ll = locs.computeIfAbsent(val, k -> new HashSet<>());
        // Add the new index to the set
        ll.add(id);
        return present;
    }

    // Helper method to poll the first element from a set
    private int pollFirst(HashSet<Integer> set) {
        Integer first = set.iterator().next();
        set.remove(first);
        return first;
    }

    // Removes an item from the collection. Returns true if the item was present, false otherwise.
    public boolean remove(int val) {
        if (locs.containsKey(val)) {
            HashSet<Integer> ll = locs.get(val);
            if (!ll.isEmpty()) {
                // Get the index of the value to be removed
                int id = pollFirst(ll);
                // If the index is not the last one in the list, replace it with the last element
                if (id < list.size() - 1) {
                    int oldId = list.size() - 1;
                    int lastVal = list.remove(oldId);
                    list.set(id, lastVal);
                    replaceLastFromMap(lastVal, oldId, id);
                } else {
                    list.remove(list.size() - 1);
                }
                // Remove the value from the map if no indices are left
                if (ll.isEmpty()) {
                    locs.remove(val);
                }
                return true;
            }
        }
        return false;
    }

    // Helper method to replace the last element in the map
    private void replaceLastFromMap(int lastVal, int oldId, int newId) {
        HashSet<Integer> ll = locs.get(lastVal);
        ll.remove(oldId);
        ll.add(newId);
    }

    // Returns a random element from the collection.
    public int getRandom() {
        int r = rand.nextInt(list.size());
        return list.get(r);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

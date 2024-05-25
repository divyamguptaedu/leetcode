//I used a combination of an ArrayList and a HashMap to achieve O(1)
//time complexity for insert, delete, and getRandom operations. 
//The ArrayList allowed direct access to elements by index for efficient random selection. 
//The HashMap tracked element positions in the ArrayList for constant-time lookups and removals. 
//On insert, I added the element to the list and updated the map. 
//On remove, I swapped the target element with the last element in the list, removed the last element, 
//and updated the map accordingly. For getRandom, I returned a random element from the list.

//Time: O(1) for all operations
//Space: O(n)

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

class RandomizedSet {
    private ArrayList<Integer> list; // To store the elements
    private Map<Integer, Integer> map; // To store element indices for quick lookup

    public RandomizedSet() {
        list = new ArrayList<>(); // Initialize the list
        map = new HashMap<>(); // Initialize the map
    }

    // Method to check if an element is in the set
    public boolean search(int val) {
        return map.containsKey(val);
    }

    // Method to insert an element into the set
    public boolean insert(int val) {
        if (search(val)) // If the element is already in the set, return false
            return false;

        list.add(val); // Add the element to the list
        map.put(val, list.size() - 1); // Add the element and its index to the map
        return true;
    }

    // Method to remove an element from the set
    public boolean remove(int val) {
        if (!search(val)) // If the element is not in the set, return false
            return false;

        int index = map.get(val); // Get the index of the element to remove
        int lastElement = list.get(list.size() - 1); // Get the last element in the list

        list.set(index, lastElement); // Replace the element to remove with the last element
        map.put(lastElement, index); // Update the map with the new index of the last element

        list.remove(list.size() - 1); // Remove the last element from the list
        map.remove(val); // Remove the element from the map

        return true;
    }

    // Method to get a random element from the set
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size())); // Return a random element from the list
    }
}
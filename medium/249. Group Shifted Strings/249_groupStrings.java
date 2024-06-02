//I used a hash map to group strings that belong to the same shifting sequence. 
//For each string, I generated a hash key representing its shifting pattern by 
//calculating the difference between each consecutive character, adjusting for
//circular shifts using modulo 26. Strings with the same hash key were grouped together. 
//I iterated over the input array, computed each string's hash key, and added the string 
//to the corresponding list in the hash map. Finally, I collected all grouped lists from 
//the hash map and returned them.

//Time: O(nk) where n is the length of strings array and k is the max length of a string.
//Space: O(nk)
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> mapHashToList = new HashMap<>();

        // Create a hash_value (hashKey) for each string and append the string
        // to the list of hash values i.e. mapHashToList["cd"] = ["acf", "gil", "xzc"]
        for (String str : strings) {
            String hashKey = getHash(str);
            if (mapHashToList.get(hashKey) == null) {
                mapHashToList.put(hashKey, new ArrayList<>());
            }
            mapHashToList.get(hashKey).add(str);
        }

        // Iterate over the map, and add the values to groups
        List<List<String>> groups = new ArrayList<>();
        for (List<String> group : mapHashToList.values()) {
            groups.add(group);
        }

        // Return a list of all of the grouped strings
        return groups;
    }

    // Create a hash value
    String getHash(String s) {
        char[] chars = s.toCharArray();
        StringBuilder hashKey = new StringBuilder();
        // Calculate the difference between each consecutive character
        // Adjust for circular shifts using modulo 26
        for (int i = 1; i < chars.length; i++) {
            hashKey.append((char) ((chars[i] - chars[i - 1] + 26) % 26 + 'a'));
        }

        return hashKey.toString();
    }
}
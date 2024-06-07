//I used a hashmap to group anagrams by creating a key for each string based
//on the frequency of each character. 
//For each string, I counted the occurrences of each character and generated
//a unique key from these counts.
//Strings with the same character counts had the same key and were grouped
//together in the hashmap. 
//After processing all strings, 
//I collected the grouped anagrams from the hashmap values and 
//returned them as the result.

//Time: nk where n is the #strings and k is the max len of a string
//Space: nk
class Solution {
    public List<List<String>> groupAnagrams(String[] strings) {
        if (strings.length == 0)
            return new ArrayList<>(); // Return empty list if input is empty

        Map<String, List<String>> groupedAnagrams = new HashMap<>();
        int[] charCount = new int[26];

        // Iterate over each string in the input array
        for (String string : strings) {
            Arrays.fill(charCount, 0); // Reset character count array

            // Count the occurrences of each character in the string
            for (char character : string.toCharArray()) {
                charCount[character - 'a']++;
            }

            // Create a unique key based on character counts
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append('#').append(count);
            }
            String key = keyBuilder.toString();

            // Add the string to the appropriate group in the hashmap
            if (!groupedAnagrams.containsKey(key)) {
                groupedAnagrams.put(key, new ArrayList<>());
            }
            groupedAnagrams.get(key).add(string);
        }

        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(groupedAnagrams.values());
    }
}
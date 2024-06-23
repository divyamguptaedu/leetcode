//I utilized a HashMap to count frequencies of each element. 
//Iterating through the array, I updated the frequency count using freq.put(num, freq.getOrDefault(num, 0) + 1). 
//Then, I used a HashSet to track these frequencies. If the size of the HashSet matches the size of the HashMap, 
//it indicates that each frequency count is unique, thus returning true; otherwise, false.
//TC: N
//SC: N
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Store the frequency of elements in the unordered map.
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Store the frequency count of elements in the unordered set.
        Set<Integer> freqSet = new HashSet<>(freq.values());
        
        // If the set size is equal to the map size, 
        // It implies frequency counts are unique.
        return freq.size() == freqSet.size();
    }
}
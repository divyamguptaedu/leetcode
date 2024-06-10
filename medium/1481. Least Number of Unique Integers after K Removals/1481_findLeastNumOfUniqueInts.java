//I first counted the frequency of each integer in the array using a HashMap.
//Then, I created an array to track how many integers have each frequency.
//I iterated through possible frequencies, removing as many integers as possible with
//each frequency until I had removed k elements.
//For each frequency, I reduced the number of unique integers accordingly.
//If I couldn't remove more integers without exceeding the remaining k,
//I returned the current count of unique integers.

//For input 4, 3, 1, 1, 3, 3, 2, the freq count will be 0, 2, 1, 1, 0, 0, 0, 0
//So, we will remove the 2 elements which appear 1 time, then move to 1 element that appear twice and remove it.

//Time: n
//Space: n

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Map to track the frequencies of elements
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int n = arr.length; // Total number of elements

        // Array to track the count of each frequency
        int[] frequencyCount = new int[n + 1];

        // Populate frequencyCount array
        for (int count : frequencyMap.values()) {
            frequencyCount[count]++;
        }

        // Variable to track the remaining number of unique elements
        int remainingUniqueElements = frequencyMap.size();

        // Traverse over all possible frequencies
        for (int i = 1; i <= n; i++) {
            // For each possible frequency, remove as many elements as possible
            int elementsToRemove = Math.min(k / i, frequencyCount[i]);

            // Update k to reflect the number of elements removed
            k -= i * elementsToRemove;

            // Decrease the count of unique elements by the number of elements removed
            remainingUniqueElements -= elementsToRemove;

            // If k is less than the current frequency, return the remaining unique elements
            if (k < i) {
                return remainingUniqueElements;
            }
        }

        // If all elements are removed, return 0
        return 0;
    }
}
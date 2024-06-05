//Can be solved using a hashmap or an array. Let's do the hashmap way first.

//To solve the problem, I maintained a running count where 1 is added for each 1 and 
//subtracted for each 0. I used a hashmap to store the first occurrence of each count value. 
//If a count value reappeared, it indicated a subarray with equal numbers of 0s and 1s. 
//By calculating the difference between the current index and the stored index of the 
//first occurrence of that count, I found the length of such subarrays. 
//I kept track of the maximum length found during this process.

//Time: n
//Space: n
class Solution {
    public int findMaxLength(int[] nums) {
        // Initialize a map to store the first occurrence of each count value
        Map<Integer, Integer> map = new HashMap<>();
        // Start by putting a count of 0 at index -1 to handle the case when the entire array is valid
        map.put(0, -1);
        int maxlen = 0; // Variable to store the maximum length found
        int count = 0;  // Running count of 1s and 0s
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Update the count: +1 for a 1 and -1 for a 0
            count = count + (nums[i] == 1 ? 1 : -1);
            // Check if this count has been seen before
            if (map.containsKey(count)) {
                // If yes, calculate the length of the subarray and update maxlen if needed
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                // If no, store the index of this count
                map.put(count, i);
            }
        }
        return maxlen; // Return the maximum length found
    }
}

//Solution using the array instead of a hashmap

//I used an array to track the first occurrence of each count value, 
//adjusted for offset to handle negative indices. I initialized the array with -2 and 
//set the middle index (corresponding to count zero) to -1. 
//As I traversed the input array, I updated the count by adding 1 for each 1 and subtracting
//1 for each 0. If the adjusted count had been seen before, I calculated the subarray length
//from the current index minus the stored index, updating the maximum length if needed. 
//If not, I stored the current index.

//Time: n
//Space: n

class Solution2 {
    public int findMaxLength(int[] nums) {
        // Initialize an array to store the first occurrence of each count value
        int[] arr = new int[2 * nums.length + 1];
        // Fill the array with -2 to indicate uninitialized positions
        Arrays.fill(arr, -2);
        // Set the middle index, corresponding to count zero, to -1
        arr[nums.length] = -1;
        int maxlen = 0; // Variable to store the maximum length found
        int count = 0;  // Running count of 1s and 0s
        
        // Iterate through the input array
        for (int i = 0; i < nums.length; i++) {
            // Update the count: +1 for a 1 and -1 for a 0
            count = count + (nums[i] == 0 ? -1 : 1);
            // Check if this count has been seen before by adjusting the index
            if (arr[count + nums.length] >= -1) {
                // If yes, calculate the length of the subarray and update maxlen if needed
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                // If no, store the index of this count
                arr[count + nums.length] = i;
            }
        }
        return maxlen; // Return the maximum length found
    }
}

//I iterate through the array, creating a copy and sorting it to determine the ranks.
//I use a HashMap to store each unique element and its corresponding rank. 
//Then, I iterate through the original array, assigning ranks based on the HashMap values.
//Finally, I return the rank array. 

//Time: O(nlogn)
//Space: O(n)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sortedArr = new int[n];
        int[] ranks = new int[n];
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        // Create a copy of the original array and sort it
        for (int i = 0; i < n; i++) {
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);

        int currentRank = 1; // Initialize the rank
        if (n >= 1)
            rankMap.put(sortedArr[0], currentRank); // Assign rank to the smallest element
        for (int i = 1; i < n; i++) {
            if (sortedArr[i] > sortedArr[i - 1]) { // Increment rank for each unique element
                currentRank++;
                rankMap.put(sortedArr[i], currentRank);
            }
        }

        // Assign ranks to original elements based on rankMap
        for (int i = 0; i < n; i++) {
            ranks[i] = rankMap.get(arr[i]);
        }
        return ranks;
    }
}

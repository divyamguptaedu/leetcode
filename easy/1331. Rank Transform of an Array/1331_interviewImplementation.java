import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Create a HashMap to store unique elements and their ranks
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        
        // Create a copy of the array to not modify the original
        int[] sortedArr = arr.clone();
        
        // Sort the copy of the array
        Arrays.sort(sortedArr);
        
        // Assign ranks to each unique element in the sorted array
        int rank = 1;
        for (int i = 0; i < sortedArr.length; i++) {
            if (!rankMap.containsKey(sortedArr[i])) {
                rankMap.put(sortedArr[i], rank++);
            }
        }
        
        // Assign ranks to the original array based on the HashMap
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        int[] test1 = {40, 10, 20, 30}; // Expected output: [4, 1, 2, 3]
        int[] test2 = {100, 100, 100};  // Expected output: [1, 1, 1]
        int[] test3 = {37, 12, 28, 9, 100, 56, 80, 5, 12}; // Expected output: [5, 3, 4, 2, 8, 6, 7, 1, 3]
        
        // Apply rank transform and print results
        System.out.println("Rank transformed array for test1: " + Arrays.toString(solution.arrayRankTransform(test1)));
        System.out.println("Rank transformed array for test2: " + Arrays.toString(solution.arrayRankTransform(test2)));
        System.out.println("Rank transformed array for test3: " + Arrays.toString(solution.arrayRankTransform(test3)));
    }
}

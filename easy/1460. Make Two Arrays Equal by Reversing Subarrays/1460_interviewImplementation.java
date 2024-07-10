public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] countMap = new int[1001]; // Map that holds count of integers

        // Iterate through the arrays
        for (int i = 0; i < target.length; i++) {
            countMap[target[i]]++; // Increment count of integer found in target array
            countMap[arr[i]]--;    // Decrement count of integer found in arr array
        }

        // Iterate countMap
        for (int count : countMap) {
            // If not 0, it means target and arr do not match
            if (count != 0) {
                return false; // Return false
            }
        }

        // If this point is reached, the arrays are equal
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] target1 = {1, 2, 3, 4};
        int[] arr1 = {2, 4, 1, 3};
        System.out.println("Can arr1 be made equal to target1? " + solution.canBeEqual(target1, arr1)); // Expected: true

        int[] target2 = {7};
        int[] arr2 = {7};
        System.out.println("Can arr2 be made equal to target2? " + solution.canBeEqual(target2, arr2)); // Expected: true

        int[] target3 = {1, 12};
        int[] arr3 = {12, 1};
        System.out.println("Can arr3 be made equal to target3? " + solution.canBeEqual(target3, arr3)); // Expected: true

        int[] target4 = {3, 7, 9};
        int[] arr4 = {3, 7, 11};
        System.out.println("Can arr4 be made equal to target4? " + solution.canBeEqual(target4, arr4)); // Expected: false
    }
}

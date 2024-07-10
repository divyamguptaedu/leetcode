import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int insertIndex = 1; // Index to store the next unique element
        
        for (int i = 1; i < nums.length; i++) {
            // Skip duplicates
            if (nums[i] != nums[i - 1]) {
                // Store the unique element at insertIndex and increment it
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        
        return insertIndex; // Return count of unique elements
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases as per the custom judge criteria
        int[] nums1 = {1, 1, 2};
        int[] expected1 = {1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Test 1 Result:");
        System.out.println("k1: " + k1);
        System.out.println("nums1: " + Arrays.toString(nums1));
        assert k1 == expected1.length;
        for (int i = 0; i < k1; i++) {
            assert nums1[i] == expected1[i];
        }

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expected2 = {0, 1, 2, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Test 2 Result:");
        System.out.println("k2: " + k2);
        System.out.println("nums2: " + Arrays.toString(nums2));
        assert k2 == expected2.length;
        for (int i = 0; i < k2; i++) {
            assert nums2[i] == expected2[i];
        }
    }
}

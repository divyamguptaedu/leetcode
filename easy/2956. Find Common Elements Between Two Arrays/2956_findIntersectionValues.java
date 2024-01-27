public class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        for (int num : nums1) {
            firstSet.add(num);
        }

        for (int num : nums2) {
            secondSet.add(num);
        }

        int firstCounter = 0;
        for (int num : nums1) {
            if (secondSet.contains(num)) {
                firstCounter++;
            }
        }

        int secondCounter = 0;
        for (int num : nums2) {
            if (firstSet.contains(num)) {
                secondCounter++;
            }
        }

        return new int[]{firstCounter, secondCounter};
    }
}
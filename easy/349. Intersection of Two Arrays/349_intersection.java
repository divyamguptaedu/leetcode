//We just use a hashset to store all the unique elements of num1, and then iterative over the nums2.
//For every element in nums2, we check if it present in the set, if yes, we add that to the result list
//and remove it from the map.
//Time: O(n+m)
//Space: O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        // Initialize seen set and result list
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        // Mark values occurring in nums1
        for (int x : nums1) {
            seen.add(x);
        }

        // Check if n is in dictionary and not in the result
        for (int x : nums2) {
            if (seen.contains(x)) {
                result.add(x);
                seen.remove(x);
            }
        }

        // Convert to int array
        return result.stream().mapToInt(i -> i).toArray();

    }
}
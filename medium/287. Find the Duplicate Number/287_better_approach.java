"""
Performance:
Runtime: 21 ms, faster than 36.23% of Java online submissions for Find the Duplicate Number.
Memory Usage: 51.9 MB, less than 92.51% of Java online submissions for Find the Duplicate Number.
"""

class Solution {

	// add all num in nums to a set and return if already there.
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }
}
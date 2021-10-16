"
Performance:
Runtime: 10 ms, faster than 34.01% of Java online submissions for Contains Duplicate.
Memory Usage: 54 MB, less than 9.29% of Java online submissions for Contains Duplicate.
"

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }
}
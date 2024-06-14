//Just added all elements to a hashset, and if we encounter any element in the set, 
//which already existed, then we return true, if not false.
//Time: n
//Space: n
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x))
                return true;
            set.add(x);
        }
        return false;
    }
}
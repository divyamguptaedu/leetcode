class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        helper(rooms, set, 0);
        return set.size() == rooms.size();
    }

    public void helper(List<List<Integer>> rooms, HashSet<Integer> set , int curr) {
        for (int next : rooms.get(curr)) {
            if (!set.contains(next)) {
                set.add(next);
                helper(rooms, set, next);
            }
        }
    }
}
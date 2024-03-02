class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int minimum = Integer.MAX_VALUE;
        for (int i : map.values()) {
            minimum = Math.min(i, minimum);
        }
        for (int i = minimum; i > 0; i-- ) {
            int groups = 0;
            for (int current : map.values()) {
                int temp = current % (i + 1);
                int numGroups = current / (i + 1);
                if (temp == 0) {
                    groups += numGroups;
                } else if (numGroups >= i - temp) {
                    groups += numGroups + 1;
                } else {
                    groups = 0;
                    break;
                }
            }
            if (groups > 0) {
                return groups;
            }
        }
        return nums.length;
    }
}
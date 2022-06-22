"""
Performance:
Runtime: 41 ms, faster than 14.89% of Java online submissions for Increasing Subsequences.
Memory Usage: 77.5 MB, less than 11.86% of Java online submissions for Increasing Subsequences.
"""

class Solution {
   public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            list.add(new LinkedList<>(Arrays.asList(i)));
        }
        while (!list.isEmpty()) {
            set.clear();
            LinkedList<Integer> temp = list.removeFirst();
            if (temp.size() > 1) {
                LinkedList<Integer> tempTwo = new LinkedList<>();
                for (int i : temp) {
                    tempTwo.add(nums[i]);
                }
                result.add(tempTwo);
            }
            int end = temp.getLast();
            for (int i = end + 1; i < n; i++) {
                if (nums[i] < nums[end] || set.contains(nums[i])) {
                    continue;
                }
                set.add(nums[i]);
                LinkedList<Integer> next = new LinkedList<>(temp);
                next.add(i);
                list.add(next);
            }
        }
        return result;
    }
}
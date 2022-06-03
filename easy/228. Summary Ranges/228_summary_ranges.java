"
Performance:
Runtime: 9 ms, faster than 41.45% of Java online submissions for Summary Ranges.
Memory Usage: 42.6 MB, less than 28.87% of Java online submissions for Summary Ranges.
"

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            if (temp != nums[i]) {
                result.add(temp + "->" + nums[i]);
            } else {
                result.add(temp + "");
            }
        }
        return result;
    }
}
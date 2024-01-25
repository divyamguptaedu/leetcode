class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0) {
            result.add(List.of(lower,upper));
        }

        int prev = lower;
        for (int n : nums) {
            if (n == prev) {
                prev++;
            }
            else {
                List<Integer> range = new ArrayList<>();
                range.add(prev);
                range.add(n-1);
                result.add(range);
                prev = n + 1;
            }
        }

        if (nums.length > 0 && nums[nums.length-1] != upper) {
            List<Integer> range = new ArrayList<>();
            range.add(nums[nums.length-1]+1);
            range.add(upper);
            result.add(range);
        }

        return result;
    }
}
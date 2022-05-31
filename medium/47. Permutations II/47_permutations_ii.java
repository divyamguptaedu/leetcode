"""
Performance:
Runtime: 2 ms, faster than 92.47% of Java online submissions for Permutations II.
Memory Usage: 42.7 MB, less than 98.37% of Java online submissions for Permutations II.
"""

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void fun(int temp, int[]nums) {
        if (temp == nums.length){
            List<Integer> answer = new ArrayList<>();
        for (int n : nums) {
            answer.add(n);
        }
        result.add(answer);
        return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = temp; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                continue;
            }
            hashSet.add(nums[i]);
            swap(i, temp, nums);
            fun(temp + 1, nums);
            swap(i, temp, nums);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        fun(0, nums);
        return result;
    }
}
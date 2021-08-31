"
Performance:
Runtime: 66 ms, faster than 49.59% of Java online submissions for Random Pick Index.
Memory Usage: 48.8 MB, less than 51.69% of Java online submissions for Random Pick Index.
"

class Solution {
    
    Map<Integer, List<Integer>> valueMap;
    Random random;
    
    public Solution(int[] nums) {
        valueMap = new HashMap<>();
        random = new Random();
        List<Integer> list;
        for(int i = 0;i < nums.length; i++) {
            list = valueMap.getOrDefault(nums[i], new ArrayList<Integer>());
            list.add(i);
            valueMap.put(nums[i], list);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = valueMap.get(target);
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
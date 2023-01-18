class Solution {
    public int[] findRightInterval(int[][] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n = nums.length;
        if (n == 1) {
            return new int[]{-1};
        }
        for (int i = 0;i < n; i++) {
            map.put(nums[i][0], i);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            Integer key = map.ceilingKey(nums[i][1]);
            result[i] = key == null ? -1 : map.get(key);
        }
        return result;
       
    }
}
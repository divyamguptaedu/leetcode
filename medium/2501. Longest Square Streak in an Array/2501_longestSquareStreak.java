class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        int result =- 1;
        for (int x : nums){
            int perfect = (int) Math.sqrt(x);
            if (perfect * perfect == x && map.containsKey(perfect)) {
                map.put(x, map.get(perfect) + 1);
                result = Math.max((map.get(perfect) + 1), result);   
            } else {
                map.put(x,1);
            }
        }  
        return result;
    }
}
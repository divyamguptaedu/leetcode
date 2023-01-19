class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        Map<String, Integer> map = new HashMap();
        return  helper(nums.length - 1, s, nums, map);
    }
    static int helper( int n, int s, int arr[], Map<String, Integer> map ){
        if (n == -1 && s == 0) {
            return 1;
        }
        if (n <= -1 ) {
            return 0;
        }
        if (map.containsKey(n +" "+ s)) {
            return map.get(n +" "+ s);
        }
        int result_one = helper(n - 1, s - arr[n], arr, map);
        int result_two = helper(n - 1, s + arr[n], arr, map);
        map.put(n + " " + s, (result_one + result_two)); 
        return (result_one + result_two);
    }
}
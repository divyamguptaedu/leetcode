"
Performance:
Runtime: 12 ms, faster than 39.12% of Java online submissions for Pairs of Songs With Total Durations Divisible by 60.
Memory Usage: 44.4 MB, less than 80.15% of Java online submissions for Pairs of Songs With Total Durations Divisible by 60.
"

class Solution {
	public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        
        for (int i = 0; i < time.length; i++) {
            int mod = time[i] % 60;
            int rem = mod == 0 ? 0 : 60 - mod;
            count += map.getOrDefault(rem, 0);
            map.put(mod, 1 + map.getOrDefault(mod, 0));
        }
        
        return count;
 	}
 }
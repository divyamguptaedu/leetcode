"
Performance:
Runtime: 632 ms, faster than 17.24% of Java online submissions for Maximize Score After N Operations.
Memory Usage: 46 MB, less than 22.76% of Java online submissions for Maximize Score After N Operations.
"

class Solution {
    Map<List<List<Integer>>, Integer> valueMap = new HashMap<>();
    public int maxScore(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        valueMap = new HashMap<>();
        List<Integer> input = new ArrayList<>();
        for(int n : nums){
            input.add(n);
        }
        
        return max(input, 1);
        
    }
    
    
    public int max(List<Integer> input, int ind){
        
        if (input.size() == 0) {
        	return 0;
        }
        Collections.sort(input);
        
        if (valueMap.containsKey(getList(ind, input))) {
        	return valueMap.get(getList(ind, input));
        }
        
        int max = 1;
        for (int i = 1;i<input.size();i++) {
            for (int j = 0;j<i;j++) {
                int one = input.remove(j);
                int two = input.remove(i-1);
                max = Math.max(max, helper(one, two) * ind + max(input, ind+1));
                input.add(i-1, two);
                input.add(j, one);
            }
        }
        
        valueMap.put(getList(ind, input), max);
        return max;
        
    }
    
    int helper(int a, int b){
        if (b == 0) {
        	return 1;
        }
        if (a % b == 0) {
        	return b;
        }
        return helper(b, a%b);
    }
                                           
    List<List<Integer>> getList(int ind, List<Integer> in){
        return new ArrayList(){{add(new ArrayList(){{add(ind);}}); add(in);}};
    }
}
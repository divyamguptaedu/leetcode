"""
Performance:
Runtime: 18 ms, faster than 68.98% of Java online submissions for Subarray Sum Equals K.
Memory Usage: 41.5 MB, less than 46.46% of Java online submissions for Subarray Sum Equals K.
"""
/*
Brute Force:

iter (start -> end)
    iter (start + 1 -> end)
        iter (start -> start + 1)
            if (sum == 0)
                count++
ret count
*/

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++)
                    sum += nums[i];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}

/*
HashMap Approach:

map.put(0,1)
iter (start -> end)  
    add to sum
    if map already has the answer
        increase count
    else 
        put the answer
ret count            
*/

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap <Integer, Integer> valueMap = new HashMap<>();
        valueMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (valueMap.containsKey(sum - k)) {
                count += valueMap.get(sum - k);
            }
            valueMap.put(sum, valueMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
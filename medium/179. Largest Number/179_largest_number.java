"
Performance:
Runtime: 9 ms, faster than 59.63% of Java online submissions for Largest Number.
Memory Usage: 44.7 MB, less than 13.83% of Java online submissions for Largest Number.
"

class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        String[] result = new String[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(result, (a, b) -> {
           return (b + a).compareTo(a + b);
        });
        
        if (result[0].equals("0")) {
            return "0";
        }
        
        return String.join("", result);
    }
}
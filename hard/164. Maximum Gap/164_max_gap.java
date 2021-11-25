"
Performance:
Runtime: 78 ms, faster than 25.29% of Java online submissions for Maximum Gap.
Memory Usage: 97.8 MB, less than 21.18% of Java online submissions for Maximum Gap.
"

class Solution {
    public int maximumGap(int[] nums) {
        int max = nums[0]; 
		for (int i = 1; i < nums.length; i++) { 
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int[] result = new int[nums.length];
	    int temp = 1;
        while (max / temp > 0) { 
              int[] count = new int[10]; 
              for (int i = 0; i < nums.length; i++) { 
                  count[(nums[i] /temp) % 10]++;
              }  
              for (int i = 1; i < 10; i++) {  
                  count[i] += count[i - 1];
              }
              for (int i = nums.length - 1; i >= 0; i--) {
                  result[count[(nums[i] / temp) % 10] - 1] = nums[i];   
                  count[(nums[i] / temp) % 10]--;
              }
              for (int i = 0;i < nums.length; i++) {
                   nums[i] = result[i];
              }
              temp = temp * 10;
        }
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            answer = Math.max(answer, nums[i] - nums[i - 1]);
        }
        return answer;
    }
}
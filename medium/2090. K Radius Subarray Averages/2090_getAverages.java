//For this question, we can use the sliding window approach. 
//We initially iterate over the nums array till a window size is reached. Once reached, we divide the sum by the length
//and save the avg to the answer array. Then we subtract the sum with the first value and increment the start and end index.

//Time: O(n)
//Space: O(1)
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        int i = 0;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            if (j - i + 1 == (2 * k) + 1) {
                answer[(i + j) / 2] = (int) (sum / ((2 * k) + 1));
                sum -= nums[i];
                i++;
            }
        }
        return answer;
    }
}

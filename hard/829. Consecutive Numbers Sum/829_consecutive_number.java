"
Performance:
Runtime: 3 ms, faster than 92.59% of Java online submissions for Consecutive Numbers Sum.
Memory Usage: 35.7 MB, less than 62.45% of Java online submissions for Consecutive Numbers Sum.
"

class Solution {
 	public int consecutiveNumbersSum(int N) {
		int result = 1;
		int sum = 0;
		int i = 2;

		while (sum < N){
			sum += i - 1;
			if ((N - sum > 0) && (N - sum) % i == 0) result++;
			i++;
		}

		return result;
	}
}
"
Performance
Runtime: 3 ms, faster than 31.52% of Java online submissions for Counting Bits.
Memory Usage: 45.3 MB, less than 6.04% of Java online submissions for Counting Bits.
"

class Solution {
	public int[] countBits(int num) {
	    int[] result = new int[num + 1];
	    result[0]  = 0;
	    int power = 1;
	    for (int i = 1, t = 0; i <= num; i++, t++) {
	        if (i == power) {
	            power *= 2;
	            t = 0;
	        }
	        result[i] = result[t] + 1;
	    }
	    return result;
	}
}
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++, n = n >> 1) {
            if ((n & 1) == 1) {
                result++;
            }
            if (i != 31) {
                result *= 2;
            }
        }
        return result;
    }
}
class Solution {
    public int[] evenOddBit(int n) {
        int x = 1 << 9; // as 1<=n<=1000 is given in constraints
        int even = 0, odd = 0;
        int i = 0;
        int[] ans = new int[2];
        while (i < 10) {
            if ((n & x) > 0 && i % 2 == 0)
                odd++;
            else if ((n & x) > 0 && i % 2 == 1)
                even++;
            i++;
            x = x >> 1;
        }
        ans[0] = even;
        ans[1] = odd;
        return ans;
    }
}
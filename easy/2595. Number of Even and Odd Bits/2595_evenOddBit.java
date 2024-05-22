//I approached the problem by analyzing the binary representation of n. 
//I initialized x to 1 << 9 to handle numbers up to 1000 and set even and odd counters to 0. 
//I used a loop to iterate over the first 10 bits of n. 
//For each bit, I checked if it was set using n & x. 
//If the bit was set and its position was even, I incremented the odd counter; 
//if the position was odd, I incremented the even counter. 
//I shifted x right by one in each iteration and stored the results in an array.

//Time: O(n)
//Space: O(1)
class Solution {
    public int[] evenOddBit(int n) {
        int x = 1 << 9; // as 1<=n<=1000 is given in constraints
        int even = 0;
        int odd = 0;
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
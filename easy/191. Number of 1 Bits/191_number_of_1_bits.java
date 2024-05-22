//I solved the problem by counting the number of set bits (1s) in the binary representation of n. 
//I initialized a counter sum to 0. While n was not zero, 
//I incremented sum and used the operation n &= (n - 1) to turn off the rightmost set bit of n. 
//This operation reduces the number of set bits in n by one in each iteration. 
//I repeated this process until all set bits were turned off. 
//Finally, I returned the value of sum, which represented the total number of set bits in n.

//Time: O(1)
//Space: O(1)
class Solution {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
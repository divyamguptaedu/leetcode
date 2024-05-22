//I reversed the bits of a 32-bit unsigned integer by iterating through each bit of the input. 
//I initialized ret to 0 and power to 31. In a loop, I checked the least significant bit of 
//n using n & 1 and shifted it to the corresponding position in ret by left-shifting it by power. 
//I then right-shifted n by one to process the next bit and decremented power. 
//This process continued until all bits were processed. 
//Finally, I returned ret, which contained the reversed bits of the original integer.

//Time: O(1)
//Space: O(1)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        int power = 31;
        while (n != 0) {
            ret += (n & 1) << power;
            n = n >>> 1; //unsigned right shift, logical right shift
            power -= 1;
        }
        return ret;
    }
}
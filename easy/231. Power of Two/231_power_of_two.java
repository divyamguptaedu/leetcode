//I utilized a bitwise approach. First, I handled the edge case where n is 0, returning false immediately. 
//Then, I cast n to a long integer x to handle the case where n is Integer.MIN_VALUE without overflow issues. 
//The core logic checks if x and x - 1 bitwise AND results in 0, 
//which only occurs if x is a power of two (i.e., has exactly one bit set to 1).
//TC: CONSTANT
//SC: CONSTANT
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}
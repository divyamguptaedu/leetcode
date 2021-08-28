/*
divide by 4
false if rem not 0
recurse on n / 4

edgecase -> n is 0 or 1
*/
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 0) {
        	return false;
        }
        if (n == 1) {
        	return true;
        }
        if (n % 4 != 0) {
        	return false;
        }
        return isPowerOfFour(n / 4);    
    }
}
/*
if n is 1, true
cal for n/2

edge case -> n < 1
		  -> remainder is not 0
*/

public boolean isPowerOfTwo(int n) {
    if (n == 1) {
    	return true;
    }
    if ((n < 1) || (n % 2 != 0)) {
    	return false; 
    }
    return isPowerOfTwo(n / 2);
}
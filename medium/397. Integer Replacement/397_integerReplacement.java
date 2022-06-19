"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Integer Replacement.
Memory Usage: 41.1 MB, less than 40.51% of Java online submissions for Integer Replacement.
"""

class Solution {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32; 
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int temp = 0;
        while (n > 1) {  
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                if ((n + 1) % 4 == 0 && n!=3) {
                    n++;
                } else {
                    n--;
                }
            }
			temp++;
        }
        return temp;                
    }
}
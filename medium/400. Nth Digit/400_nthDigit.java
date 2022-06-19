"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Nth Digit.
Memory Usage: 40.4 MB, less than 79.27% of Java online submissions for Nth Digit.
"

class Solution {
    public int findNthDigit(int n) {
        long nineMultiple = 9;
        long count = 1;
        long x = 1;
        long limit = nineMultiple * count;
        while (n > limit) {
                n -= limit;
                x = x * 10L;
                nineMultiple *= 10L;
                count +=1;
                limit = nineMultiple * count;
        }
        long result = x + (n  - 1)  / count;
        long temp =  (n  - 1)  % count;
        for (int i = 0; i < count - temp -1; i++) {
           result /= 10L;
        }
        return (int)result % 10;
    };
    
}
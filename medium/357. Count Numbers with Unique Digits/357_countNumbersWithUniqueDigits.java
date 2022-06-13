"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Numbers with Unique Digits.
Memory Usage: 41 MB, less than 38.49% of Java online submissions for Count Numbers with Unique Digits.
"

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1){
            return 10;
        }
        int result = 10;
        int count = 9;
        int increment = 9;
        while (n > 1 && count >= 0) {
            increment = increment * count;
            result += increment;
            n--;
            count--;
        }
        return result;
    }
}
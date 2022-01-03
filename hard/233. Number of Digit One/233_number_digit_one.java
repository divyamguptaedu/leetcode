"""
Performance: 
Performance:
Runtime: 0 ms, faster than 99.45% of Java online submissions for Number of Digit One.
Memory Usage: 37.7 MB, less than 34.57% of Java online submissions for Number of Digit One.
"""

class Solution {
    public static int countDigitOne(int number) {
        int count = 0;
        int factor = 1;
        int temp = number;
        while (temp > 0) {
            int multiple = temp / 10;
            int remainder = temp%10;
            int amount;

            if (remainder == 0) {
                amount = 0;
            } else if (remainder > 1) {
                amount = factor;
            } else {
                amount = number % factor + 1;
            }
            count += multiple*factor + amount;
            factor *= 10;
            temp = temp/10;
        }
        return count;
    }
}

"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Digit One.
Memory Usage: 37.7 MB, less than 17.88% of Java online submissions for Number of Digit One.
"
class Solution {
    int digit = 1;
    public int countDigitOne(int number) {
        if (number == 0) {
            return 0;
        }
        int power     = (int) Math.log10(number);
        int remainder = (int) (number % Math.pow(10, power));
        int multiple   = (int) (number / Math.pow(10, power));
        if (power == 0) {
            if (number >= digit) {
                return 1;
            } else {
                return 0;
            }
        }
        if (multiple == digit) {
            return 1 + remainder + helper(power) + countDigitOne(remainder);
        }
        return helper(multiple, power) + countDigitOne(remainder);
    }
    
    public int helper(int power) {
        return power * (int) Math.pow(10, power - 1);
    }
    
    public int helper(int power, int leftout) {
        return (leftout - 1) * helper(power) + (10 + power) * (int) Math.pow(10, power - 1);
    }
}
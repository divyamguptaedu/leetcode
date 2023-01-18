class Solution {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        double lastCount = 9;
        double base = 10;
        double previous = 0;
        double count = 1;
        while (n > lastCount) {
            count++;
            previous = lastCount;
            lastCount += 9 * digitCount * base;
            base *= 10 ;
        }
        double remainingCount = n - previous;
        int whereItsAt = (int) ((base/10 - 1d) + Math.ceil(remainingCount / count));
        double mod = remainingCount % count;
        int whichChar = (int) ((mod == 0 ? count : mod) - 1d);
        return Character.getNumericValue(String.valueOf(whereItsAt).charAt(whichChar));
    }
}
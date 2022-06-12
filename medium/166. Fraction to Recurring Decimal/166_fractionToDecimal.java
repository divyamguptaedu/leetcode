"
Performance:
Runtime: 1 ms, faster than 100.00% of Java online submissions for Fraction to Recurring Decimal.
Memory Usage: 41.7 MB, less than 45.38% of Java online submissions for Fraction to Recurring Decimal.
"

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            result.append("-");
        }
        long divisor = Math.abs((long) numerator);
        long dividend = Math.abs((long) denominator);
        long remainder = divisor % dividend;
        result.append(divisor / dividend);
        if (remainder == 0) {
            return result.toString();
        }
        result.append(".");
        Map<Long, Integer> hashMap = new HashMap<>();
        while (remainder != 0) {
            if(hashMap.containsKey(remainder)) {
                result.insert(hashMap.get(remainder), "(");
                result.append(")");
                break;
            }
            hashMap.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / dividend);
            remainder %= dividend;
        }
        return result.toString();
    }
}
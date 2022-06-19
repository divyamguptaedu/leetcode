"""
Performance:
Runtime: 11 ms, faster than 93.29% of Java online submissions for Remove K Digits.
Memory Usage: 42.4 MB, less than 98.88% of Java online submissions for Remove K Digits.
"""

class Solution {
    public String removeKdigits(String num, int k) {
        int size = num.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < size ; i++){
            while (k > 0 && result.length() > 0 && result.charAt(result.length()-1) > num.charAt(i)) {
                k--;
                result.deleteCharAt(result.length()-1);
            }
            result.append(num.charAt(i));
        }
        while (k > 0 && result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;                
        }      
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result.toString().substring(index);
    }
}
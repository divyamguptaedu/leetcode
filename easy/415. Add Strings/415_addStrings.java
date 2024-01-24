class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int first = (i < 0) ? 0 : num1.charAt(i) - '0';
            int second = (j < 0) ? 0 : num2.charAt(j) - '0';

            int totalSum = first + second + carry;
            result.append(totalSum % 10);
            carry = totalSum / 10;

            i--;
            j--;
        }

        if (carry == 1) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
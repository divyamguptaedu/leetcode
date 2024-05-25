class Solution {
    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int sum = 0, carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            sum = 0 + carry;
            if (i >= 0) {
                sum += (int) num1.charAt(i) - 48;
                i--;
            }
            if (j >= 0) {
                sum += (int) num2.charAt(j) - 48;
                j--;
            }
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
        }

        if (carry == 1) {
            carry = 0;
            sb.append(1);
        }

        sb = sb.reverse();
        return sb.toString();

    }
}
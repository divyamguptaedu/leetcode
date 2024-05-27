//To solve the problem of multiplying two numbers represented as strings, 
//I reversed both input strings to facilitate digit-by-digit multiplication from least significant to most significant digits. 
//I then used an array to store intermediate results, simulating manual multiplication. 
//For each digit in the second number, I multiplied it with each digit in the first number, 
//adding the results to the corresponding positions in the array while handling carries. 
//After processing all digits, 
//I removed any leading zeros and reversed the result to form the final product as a string.

//Time: O(n*m) where n and m are the lengths of num1 and num2
//Space: O(n+m)
class Solution {
    public String multiply(String num1, String num2) {
        // If either number is "0", the product is "0".
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // Reverse both numbers to facilitate easier multiplication.
        StringBuilder firstNumber = new StringBuilder(num1);
        StringBuilder secondNumber = new StringBuilder(num2);
        firstNumber.reverse();
        secondNumber.reverse();

        // The maximum length of the result will be the sum of the lengths of the two numbers.
        int N = firstNumber.length() + secondNumber.length();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            answer.append(0);
        }

        // Multiply each digit of the second number by each digit of the first number.
        for (int place2 = 0; place2 < secondNumber.length(); place2++) {
            int digit2 = secondNumber.charAt(place2) - '0';

            for (int place1 = 0; place1 < firstNumber.length(); place1++) {
                int digit1 = firstNumber.charAt(place1) - '0';

                int currentPos = place1 + place2;
                int carry = answer.charAt(currentPos) - '0';
                int multiplication = digit1 * digit2 + carry;

                // Set the ones place of the multiplication result.
                answer.setCharAt(currentPos, (char) ((multiplication % 10) + '0'));

                // Carry the tens place of the multiplication result to the next position.
                int value = (answer.charAt(currentPos + 1) - '0') + multiplication / 10;
                answer.setCharAt(currentPos + 1, (char) (value + '0'));
            }
        }

        // Remove any leading zeros from the result.
        if (answer.charAt(answer.length() - 1) == '0') {
            answer.deleteCharAt(answer.length() - 1);
        }

        // Reverse the result to get the final product.
        answer.reverse();
        return answer.toString();
    }
}

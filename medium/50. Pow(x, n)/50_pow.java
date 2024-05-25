//I used binary exponentiation to calculate x^n . 
//If n was negative, I inverted x and made n positive. I initialized result to 1. In a loop, while n was not zero, 
//I multiplied result by x and decreased n by 1 if n was odd. 
//Then, I squared x and halved n. This repeated until n became zero, yielding the final result. 
//This approach efficiently handled both positive and negative exponents and minimized the number of multiplications.

//Time: O(log n)
//Space: O(1)
class Solution {
    // Public method to be called, converting int n to long to handle edge cases
    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }

    // Helper method to perform binary exponentiation
    private double binaryExp(double x, long n) {
        // Base case: any number raised to the power of 0 is 1
        if (n == 0) {
            return 1;
        }

        // If n is negative, convert the problem to positive exponent with reciprocal base
        if (n < 0) {
            n = -n; // Make n positive
            x = 1.0 / x; // Take reciprocal of x
        }

        double result = 1; // Initialize result to 1
        while (n != 0) {
            // If n is odd, multiply result by x and decrement n by 1
            if (n % 2 == 1) {
                result = result * x;
                n -= 1;
            }
            // Square x and halve n
            x = x * x;
            n = n / 2;
        }
        return result; // Return the final result
    }
}

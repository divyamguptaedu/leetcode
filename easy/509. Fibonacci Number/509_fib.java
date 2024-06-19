//I solved the problem by using an iterative approach to calculate the Fibonacci number. I started by checking if the input number  n was 0 or 1, returning 
//n directly if true. For larger values, I used three variables to keep track of the current Fibonacci number and the two preceding ones. I iterated from 2 to 
//n, updating these variables in each step to reflect the new values, ultimately returning the current Fibonacci number after the loop.
//Time: n
//Space: constant
class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 0;

        for (int i = 2; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
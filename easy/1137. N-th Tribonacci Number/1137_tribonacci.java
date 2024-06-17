//In solving the problem of finding the n-th Tribonacci number, 
//I used an iterative approach with three variables (a, b, c) initialized to T0, T1, and T2 
//respectively. For n < 3, the result is directly returned since T0 = 0, T1 = 1, and T2 = 1. 
//For larger n, I iteratively computed each subsequent Tribonacci number using the formula 
//Tn+3 = Tn + Tn+1 + Tn+2 until reaching Tn. 
//This approach efficiently computes the result in linear time by iterating n - 2 times. 
//It uses constant space, storing only the current values of a, b, and c.

//Time: n
//Space: constant
class Solution {
    public int tribonacci(int n) {
        if (n < 3) {
            if (n > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 0; i < n - 2; i++) {
            int tmp = a + b + c;
            a = b;
            b = c;
            c = tmp;
        }
        
        return c;
    }
}
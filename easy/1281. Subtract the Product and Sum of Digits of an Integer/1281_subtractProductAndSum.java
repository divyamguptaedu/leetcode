//I approached the problem by initializing two variables, 
//p for product and s for sum, to accumulate the respective values of digits in the integer n. 
//Using a while loop, I repeatedly extract the last digit (rem) from n, 
//update p by multiplying rem, update s by adding rem, and then reduce n by dividing it by 
//10 until n becomes 0. Finally, I return the difference between p and s.

//Time: number of digits in n
//Space: constant
class Solution {
    public int subtractProductAndSum(int n) {
        int p = 1, s = 0;
        while (n != 0) {
            int rem = n % 10;
            p *= rem;
            s += rem;
            n /= 10;
        }
        return p - s;
    }
}
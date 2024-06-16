//To solve the problem of counting prime numbers less than a given integer n, 
//I employed the Sieve of Eratosthenes algorithm. 
//Initially, I created a boolean array numbers of size n to mark non-prime numbers. 
//Starting from 2, I iterated up to the square root of n. 
//For each prime number p, if it hasn't been marked as non-prime, 
//I marked all its multiples as non-prime in the array.
//This step effectively sieves out non-prime numbers.
//After marking all non-primes, I counted the number of false entries in the numbers array, 
//which corresponds to prime numbers less than n.

//Time: root(n) log logn + n
//Space: n
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] numbers = new boolean[n];
        for (int p = 2; p <= (int) Math.sqrt(n); ++p) {
            if (numbers[p] == false) {
                for (int j = p * p; j < n; j += p) {
                    numbers[j] = true;
                }
            }
        }

        int numberOfPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (numbers[i] == false) {
                ++numberOfPrimes;
            }
        }

        return numberOfPrimes;
    }
}
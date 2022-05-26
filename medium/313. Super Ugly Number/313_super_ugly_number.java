/*
Runtime: 27 ms, faster than 91.54% of Java online submissions for Super Ugly Number.
Memory Usage: 41.7 MB, less than 94.88% of Java online submissions for Super Ugly Number.
*/

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int pointer[] = new int[primes.length];
        Arrays.fill(pointer, 1);
        int array[] = new int[n + 1];
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
              int minimum = Integer.MAX_VALUE;
              for (int j = 0; j < primes.length; j++) {
                    minimum = Math.min(minimum, primes[j] * array[pointer[j]]);
              }
              array[i] = minimum;
              for (int j = 0; j < primes.length; j++) {
                    if (primes[j] * array[pointer[j]] == minimum) {
                          pointer[j]++;
                    }
              }
        }
        return array[n];
    }
}
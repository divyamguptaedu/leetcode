/*
I approached the Bulls and Cows game solution by iterating through each character in the secret 
and guess strings simultaneously. For each character:
1. If both characters match at the same position, I count it as a bull.

2. If they do not match, I use an array h to track occurrences of digits. 
If a digit in guess matches a digit in secret seen earlier (tracked in h), it counts as a cow.

3. I adjust h accordingly: incrementing when a digit from secret is found and decrementing when a 
digit from guess is found.

After processing all characters, I construct the result string in the format "xAyB" where x is 
the number of bulls and y is the number of cows.

Time: n
Space: constant
*/
class Solution {
    public String getHint(String secret, String guess) {
        int[] h = new int[10];

        int bulls = 0, cows = 0;
        int n = guess.length();
        for (int idx = 0; idx < n; ++idx) {
            char s = secret.charAt(idx);
            char g = guess.charAt(idx);
            if (s == g) {
                bulls++;
            } else {
                if (h[s - '0'] < 0)
                    cows++;
                if (h[g - '0'] > 0)
                    cows++;
                h[s - '0']++;
                h[g - '0']--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }
}
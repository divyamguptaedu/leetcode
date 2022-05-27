/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Bulb Switcher.
Memory Usage: 40.8 MB, less than 50.27% of Java online submissions for Bulb Switcher.
*/

//brute-force

class Solution {
    public int bulbSwitch(int n) {
        int total = 0;
        for (int i = 1; i < n + 1; i++) {
            boolean on = false;
            for (int j = 1; j < n + 1; j++) {
                if (i % j == 0)
                    on = !on;
            }
            total += on ? 1 : 0;
        }
        return total;
    }
}

//simple and 100%

public class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
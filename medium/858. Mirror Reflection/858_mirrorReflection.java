"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Mirror Reflection.
Memory Usage: 41.4 MB, less than 11.86% of Java online submissions for Mirror Reflection.
"

class Solution {
    public int mirrorReflection(int p, int q) {
        int height = q;
        boolean temp = false;
        while (height % p != 0) {
            height += q;
            temp = !temp;
        }
        if (temp) {
            return 2;
        } else { 
            return (height / p) % 2;
        }
    }
}
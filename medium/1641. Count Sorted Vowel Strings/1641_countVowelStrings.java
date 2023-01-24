class Solution {
    public int countVowelStrings(int n) {
        int a;
        int e;
        int i;
        int o;
        int u;
        a = e = i = o = u = 1;
        for (int t = 1; t < n; t++) {
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            u = u;
        }
        return a + e + i + o + u;
    }
}
"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for K-th Symbol in Grammar.
Memory Usage: 41.6 MB, less than 7.19% of Java online submissions for K-th Symbol in Grammar.
"

class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1 || k == 1) {
            return 0;
        }
        int mid = (int) Math.pow(2, n - 1) / 2;
        if (mid >= k) {
            return kthGrammar(n - 1, k);
        }
        return kthGrammar(n - 1, k - mid) ^ 1;
    }
}
class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Long> powers = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                powers.add((long)Math.pow(2, i));
            }
            n >>= 1;
        }
        
        int mod = 1_000_000_007;
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int[] q = queries[i];
            long ans = 1;
            for (int j = q[0]; j <= q[1]; j++) {
                ans = (ans * powers.get(j)) % mod;
            }
            res[i] = (int) ans;
        }
        
        return res;
    }
}
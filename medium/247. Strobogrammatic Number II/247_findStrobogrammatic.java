//Time: O(N 5^(N/2 + 1))
//Space: O(N 5^(N/2))

class Solution {
    public char[][] data = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public List<String> helper(int n, int finalLength) {
        if (n == 0) {
            return new ArrayList<>(List.of(""));
        }
        
        if (n == 1) {
            return new ArrayList<>(List.of("0", "1", "8"));
        }
        
        List<String> previous = helper(n - 2, finalLength);
        List<String> current = new ArrayList<>();
        
        for (String p : previous) {
            for (char[] pair : data) {
                if (pair[0] != '0' || n != finalLength) {
                    current.add(pair[0] + p + pair[1]);
                }
            }
        }
        
        return current;
    }
}
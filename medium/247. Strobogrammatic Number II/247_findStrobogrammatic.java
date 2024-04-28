//For n = 1, the result is 0, 1, 8
//For n = 2, the result is 11, 88, 69, 96
//For n = 3, the result is 101, 111, 181, 808, 818, 888, .... basically we add numbers from 1 on the outside of numbers from n = 2, not the zero pair.
//So, we can use recursion to solve this.
//For every previous string, and for every pair in the data, we add the string in between the pair key and value.

//Time: O(N 5^(N/2 + 1)) because we have 5 pairs in the data, in each recursion, we iterate over all strings and append 5 pairs to each. 
//Space: O(N 5^(N/2))

class Solution {
    public char[][] data = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

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
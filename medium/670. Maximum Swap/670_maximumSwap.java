"
Performance:
Runtime: 1 ms, faster than 84.55% of Java online submissions for Maximum Swap.
Memory Usage: 38.9 MB, less than 97.78% of Java online submissions for Maximum Swap.
"

class Solution {
    public int maximumSwap(int num) {
        char[] result = String.valueOf(num).toCharArray();
        int[] locations = new int[10];
        Arrays.fill(locations, -1);
        for (int i = 0; i < result.length; i++) {
            locations[result[i] - '0'] = i;
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 9; j >= 0; j--) {
                if (j > result[i] - '0' && locations[j] >= 0 && i < locations[j]) {
                    helper(result, i, locations[j]);
                    return Integer.valueOf(new String(result));
                }
            }
        }
        return Integer.valueOf(new String(result));
    }
    
    public void helper(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
        return;
    }
}
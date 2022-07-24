"
Performance:
Runtime: 147 ms, faster than 96.04% of Java online submissions for Beautiful Array.
Memory Usage: 42.6 MB, less than 57.69% of Java online submissions for Beautiful Array.
"

class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer x : result) {
                if (2 * x <= n) {
                    temp.add(x  *2);
                }
            }
            for (Integer x : result) {
                if (2 * x - 1 <= n) {
                    temp.add(x * 2 - 1);
                }
            }
            result = temp;
        }
        int[] array = new int[n];
        int k = 0;
        for (Integer i : result) {
            array[k++] = i;
        }
        return array;
    }
}
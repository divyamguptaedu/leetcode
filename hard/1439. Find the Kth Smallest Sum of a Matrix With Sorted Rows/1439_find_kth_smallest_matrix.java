"""
Performance:
Runtime: 321 ms, faster than 21.19% of Java online submissions for Find the Kth Smallest Sum of a Matrix With Sorted Rows.
Memory Usage: 89.2 MB, less than 5.39% of Java online submissions for Find the Kth Smallest Sum of a Matrix With Sorted Rows.
"""

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        List<Integer> list = new ArrayList<>();
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        int length = mat[0].length;
        for (int i = 0; i < length; i++) {
            list.add(mat[0][i]);
        }
        for (int i = 1; i < mat.length; i++) {
            int[] array = mat[i];
            List<Integer> temp = new ArrayList<>();
            for (int number : list) {
                for(int x : array) {
                    temp.add(number + x);
                }
            }
            Collections.sort(temp);
            list.clear();
            for (int j = 0; j < Math.min(k, temp.size()); j++) {
                list.add(temp.get(j));
            }
        }
        return list.get(list.size() - 1);
    }
}
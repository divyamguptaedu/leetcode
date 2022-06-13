"
Performance:
Runtime: 474 ms, faster than 95.37% of Java online submissions for Remove Boxes.
Memory Usage: 124.4 MB, less than 96.71% of Java online submissions for Remove Boxes.
"

class Solution {
    int[][][] result;
    public int removeBoxes(int[] boxes) {
        this.result = new int[100][100][100];
        return helper(boxes, 0, boxes.length - 1, 1);
    }
    private int helper(int[] boxes, int left, int right, int temp) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return temp*temp;
        }
        if (result[left][right][temp] != 0) {
            return result[left][right][temp];
        }
        result[left][right][temp] = helper(boxes, left + 1, right, 1) + temp*temp;
        for (int i = left + 1; i <= right; i++) {
            if (boxes[left] == boxes[i]) {
                result[left][right][temp] = Math.max(result[left][right][temp], helper(boxes, left + 1, i - 1, 1) + helper(boxes, i, right, temp + 1));
            }
        } 
        return result[left][right][temp];
    }
};
"
Performance:
Runtime: 34 ms, faster than 11.15% of Java online submissions for Max Points on a Line.
Memory Usage: 42.7 MB, less than 11.38% of Java online submissions for Max Points on a Line.
"
class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length <= 1) {
            if (points != null) {
                return points.length;
            } else {
                return 0;
            }
        }
        int result = 1;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> count = new HashMap<String, Integer>();

            for (int j = i + 1; j < points.length; j++) {
                String slope = helper(points[i], points[j]);
                count.put(slope, count.getOrDefault(slope, 0) + 1);
                result = Math.max(result, count.get(slope));
            }
        }
        return result + 1;
    }

    public String helper(int[] a, int[] b) {
        int temp = b[1] - a[1];
        int num = b[0] - a[0];
        if (temp == 0) {
            return "null_" + b[1];
        }
        if (num == 0) {
            return a[0] + "_null";
        }
        return "" + (num * 1.0) / (temp * 1.0);
    }
    
}

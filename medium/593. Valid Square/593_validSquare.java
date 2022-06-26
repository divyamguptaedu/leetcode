"
Performance:
Runtime: 1 ms, faster than 98.31% of Java online submissions for Valid Square.
Memory Usage: 42.8 MB, less than 7.53% of Java online submissions for Valid Square.
"

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int distanceOne = -1;
        int distanceTwo = -1;
        int[][] points = {p1, p2, p3, p4};
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) { 
                int path = getDistance(points[i], points[j]);
                if (distanceOne == -1) {
                    distanceOne = path;
                } else if (distanceTwo == -1 && distanceOne != path) {
                    distanceTwo = path;
                } else if (distanceOne != path && distanceTwo != path) {
                    return false;
                }
            }
        }
        return (distanceOne == 2 * distanceTwo || distanceTwo == 2 * distanceOne) && distanceTwo != -1;
    }
    
    private int getDistance(int[] p1, int[] p2) {
        return ((p1[0] - p2[0]) * (p1[0] - p2[0])) + ((p1[1] - p2[1]) * (p1[1] - p2[1]));
    }
}
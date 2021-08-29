/*
get circle's coordinate and radius
calculate distance to point
if less than radius, add to result

for every query
    for every point
        calc distance and compare
*/
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            result[index++] = helper(query, points);
        }
        return result;
    }
    
    private int helper(int[] circle, int[][] points){
        int x = circle[0];
        int y = circle[1];
        int r = circle[2];
        int distance = 0;
        for (int[] point : points) {
            if (!isOutside(x, y, r, point)) {
                distance++;
            }
        }
        return distance;
    }
    
    private boolean isOutside(int x,int y, int radius, int[] point) {
        int a = point[0];
        int b = point[1];
        int distance = (a - x) * (a - x) + (b - y) * (b - y);
        return distance > radius * radius;
    }
}
/*
sort by distance
    sqrt(x^2 + y^2)
return top k
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        Arrays.sort(points, (a, b) -> {           
            int distanceA = (a[0]*a[0]+a[1]*a[1]);
            int distanceB = (a[0]*b[0]+b[1]*b[1]);
            return distanceB - distanceA;
        });
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }
        return result;
    }
}
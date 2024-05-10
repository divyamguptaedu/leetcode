//We can define a distance function to calculate the distance and create a modified pq which compares
//based on the distance of the points and sorts in descending order.
//We just put all the points in the pq and then just poll k top points to return.

//Time: O(NlogN)
//Space: O(N)
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1, p2) -> getDistance(p1).compareTo(getDistance(p2)));

        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    private Double getDistance(int[] point) {
        return Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
    }
}
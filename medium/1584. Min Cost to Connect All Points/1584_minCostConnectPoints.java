//I used Prim's algorithm to find the minimum cost to connect all points. Starting from an arbitrary point, 
//I kept track of the minimum distances to all other points and updated these 
//distances as I added points to the Minimum Spanning Tree (MST). 
//I repeatedly picked the smallest edge that connected a point in the MST 
//to a point outside the MST, added this edge to the MST, and updated the distances. 
//This process continued until all points were included in the MST.
//Time: n^2
//Space: n
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int numPoints = points.length;
        int totalCost = 0;
        int edgesUsed = 0;

        // Track nodes that are included in the Minimum Spanning Tree (MST)
        boolean[] inMST = new boolean[numPoints];

        // Array to keep track of the minimum distance to add each point to the MST
        int[] minDistance = new int[numPoints];
        minDistance[0] = 0;

        // Initialize all distances to infinity, except the starting point
        for (int i = 1; i < numPoints; ++i) {
            minDistance[i] = Integer.MAX_VALUE;
        }

        // Iterate until all points are included in the MST
        while (edgesUsed < numPoints) {
            int currentMinEdge = Integer.MAX_VALUE;
            int currentNode = -1;

            // Find the node with the smallest distance that is not in the MST
            for (int node = 0; node < numPoints; ++node) {
                if (!inMST[node] && currentMinEdge > minDistance[node]) {
                    currentMinEdge = minDistance[node];
                    currentNode = node;
                }
            }

            // Add this node to the MST
            totalCost += currentMinEdge;
            edgesUsed++;
            inMST[currentNode] = true;

            // Update the distances to the adjacent nodes
            for (int nextNode = 0; nextNode < numPoints; ++nextNode) {
                int weight = Math.abs(points[currentNode][0] - points[nextNode][0]) +
                             Math.abs(points[currentNode][1] - points[nextNode][1]);

                // Update the minimum distance if a shorter path is found
                if (!inMST[nextNode] && minDistance[nextNode] > weight) {
                    minDistance[nextNode] = weight;
                }
            }
        }

        return totalCost;
    }
}
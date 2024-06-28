//I approached the problem by checking for two main cases: if there's a node with two parents and if there 
//is a cycle in the graph. I used Union-Find to detect these issues. First, I iterated through the edges 
//to find a node with two parents, storing potential redundant edges. Then, I performed Union-Find to check 
//for cycles, prioritizing the most recent edge that completes the cycle or causes the two-parent issue. 
//This way, I identified the correct edge to remove.
//Time: n
//Space: n
class Solution {
    private int[] redundantEdge = { -1, -1 }, redundantEdgeTwoParents = { -1, -1 };

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] unionFind = new int[edges.length + 1];
        for (int[] edge : edges) {
            performUnion(unionFind, edge[0], edge[1]);
        }
        if (redundantEdgeTwoParents[0] != -1 && formsCycle(unionFind, redundantEdgeTwoParents[0], redundantEdgeTwoParents[1])) {
            return redundantEdgeTwoParents;
        }
        return redundantEdge;
    }

    private void performUnion(int[] unionFind, int parent, int child) {
        if (unionFind[child] != 0) {
            redundantEdge[0] = parent;
            redundantEdge[1] = child;
            redundantEdgeTwoParents[0] = unionFind[child];
            redundantEdgeTwoParents[1] = child;
            return;
        }
        unionFind[child] = parent;
        if (redundantEdge[0] == -1 && formsCycle(unionFind, parent, child)) {
            redundantEdge[0] = parent;
            redundantEdge[1] = child;
        }
    }

    private boolean formsCycle(int[] unionFind, int parent, int child) {
        Set<Integer> visitedNodes = new HashSet<>();
        return detectCycle(unionFind, parent, visitedNodes);
    }

    private boolean detectCycle(int[] unionFind, int node, Set<Integer> visitedNodes) {
        if (unionFind[node] == 0) {
            return false;
        }
        if (visitedNodes.contains(node)) {
            return true;
        }
        visitedNodes.add(node);
        return detectCycle(unionFind, unionFind[node], visitedNodes);
    }
}
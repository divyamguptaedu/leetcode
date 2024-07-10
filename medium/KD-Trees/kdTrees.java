import java.util.Comparator;

// Node class representing a point in the KD tree
class KDNode {
    double[] point;
    KDNode left, right;

    KDNode(double[] point) {
        this.point = point;
        this.left = null;
        this.right = null;
    }
}

// Comparator for sorting points based on a specific axis
class AxisComparator implements Comparator<double[]> {
    private int axis;

    AxisComparator(int axis) {
        this.axis = axis;
    }

    @Override
    public int compare(double[] o1, double[] o2) {
        return Double.compare(o1[axis], o2[axis]);
    }
}

// KD tree class
public class KDTree {
    private KDNode root;

    // Build KD tree from a list of points
    public void buildTree(double[][] points) {
        root = buildTree(points, 0);
    }

    private KDNode buildTree(double[][] points, int depth) {
        if (points == null || points.length == 0) {
            return null;
        }

        int k = points[0].length; // Dimensionality
        int axis = depth % k;

        // Sort points based on current axis
        Arrays.sort(points, new AxisComparator(axis));

        // Find median
        int medianIndex = points.length / 2;
        double[] medianPoint = points[medianIndex];

        // Create node and recursively build subtrees
        KDNode node = new KDNode(medianPoint);
        node.left = buildTree(Arrays.copyOfRange(points, 0, medianIndex), depth + 1);
        node.right = buildTree(Arrays.copyOfRange(points, medianIndex + 1, points.length), depth + 1);

        return node;
    }

    // Nearest neighbor search
    public double[] nearestNeighbor(double[] queryPoint) {
        return nearestNeighbor(root, queryPoint, 0, null, Double.POSITIVE_INFINITY);
    }

    private double[] nearestNeighbor(KDNode node, double[] queryPoint, int depth, double[] closestPoint, double closestDist) {
        if (node == null) {
            return closestPoint;
        }

        int k = queryPoint.length;
        int axis = depth % k;

        // Evaluate current node
        double dist = distance(node.point, queryPoint);
        if (dist < closestDist) {
            closestDist = dist;
            closestPoint = node.point;
        }

        // Recursively search in the most promising subtree
        int cmp = Double.compare(queryPoint[axis], node.point[axis]);
        KDNode firstSubtree = (cmp < 0) ? node.left : node.right;
        KDNode secondSubtree = (cmp < 0) ? node.right : node.left;

        closestPoint = nearestNeighbor(firstSubtree, queryPoint, depth + 1, closestPoint, closestDist);

        // Check if we need to search in the other subtree
        if (Math.abs(queryPoint[axis] - node.point[axis]) < closestDist) {
            closestPoint = nearestNeighbor(secondSubtree, queryPoint, depth + 1, closestPoint, closestDist);
        }

        return closestPoint;
    }

    // Euclidean distance between two points
    private double distance(double[] p1, double[] p2) {
        double sum = 0.0;
        for (int i = 0; i < p1.length; i++) {
            double diff = p1[i] - p2[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }

    // Example usage
    public static void main(String[] args) {
        double[][] points = {
            {2, 3},
            {5, 4},
            {9, 6},
            {4, 7},
            {8, 1},
            {7, 2}
        };

        KDTree kdTree = new KDTree();
        kdTree.buildTree(points);

        double[] queryPoint = {6, 3};
        double[] nearestNeighbor = kdTree.nearestNeighbor(queryPoint);

        System.out.println("Nearest neighbor to query point " + Arrays.toString(queryPoint) + " is " + Arrays.toString(nearestNeighbor));
    }
}

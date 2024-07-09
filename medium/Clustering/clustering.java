//N^2 DB-SCAN Approach

class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class DBSCAN {
    private static final int UNCLASSIFIED = -1;
    private static final int NOISE = -2;

    public List<List<Point>> cluster(List<Point> points, double epsilon, int minPoints) {
        int[] clusterLabels = new int[points.size()];
        for (int i = 0; i < clusterLabels.length; i++) {
            clusterLabels[i] = UNCLASSIFIED;
        }

        int clusterId = 0;
        for (int i = 0; i < points.size(); i++) {
            if (clusterLabels[i] == UNCLASSIFIED) {
                if (expandCluster(points, clusterLabels, i, clusterId, epsilon, minPoints)) {
                    clusterId++;
                }
            }
        }

        return buildClusters(points, clusterLabels, clusterId);
    }

    private boolean expandCluster(List<Point> points, int[] clusterLabels, int pointIndex, int clusterId, double epsilon, int minPoints) {
        List<Integer> seeds = regionQuery(points, pointIndex, epsilon);
        if (seeds.size() < minPoints) {
            clusterLabels[pointIndex] = NOISE;
            return false;
        }

        for (int seedIndex : seeds) {
            clusterLabels[seedIndex] = clusterId;
        }
        seeds.remove((Integer) pointIndex);

        while (!seeds.isEmpty()) {
            int currentPointIndex = seeds.get(0);
            List<Integer> result = regionQuery(points, currentPointIndex, epsilon);
            if (result.size() >= minPoints) {
                for (int resultPointIndex : result) {
                    if (clusterLabels[resultPointIndex] == UNCLASSIFIED || clusterLabels[resultPointIndex] == NOISE) {
                        if (clusterLabels[resultPointIndex] == UNCLASSIFIED) {
                            seeds.add(resultPointIndex);
                        }
                        clusterLabels[resultPointIndex] = clusterId;
                    }
                }
            }
            seeds.remove(0);
        }
        return true;
    }

    private List<Integer> regionQuery(List<Point> points, int pointIndex, double epsilon) {
        List<Integer> result = new ArrayList<>();
        Point point = points.get(pointIndex);
        for (int i = 0; i < points.size(); i++) {
            if (distance(point, points.get(i)) <= epsilon) {
                result.add(i);
            }
        }
        return result;
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    private List<List<Point>> buildClusters(List<Point> points, int[] clusterLabels, int numClusters) {
        List<List<Point>> clusters = new ArrayList<>();
        for (int i = 0; i < numClusters; i++) {
            clusters.add(new ArrayList<>());
        }
        for (int i = 0; i < points.size(); i++) {
            if (clusterLabels[i] >= 0) {
                clusters.get(clusterLabels[i]).add(points.get(i));
            }
        }
        return clusters;
    }
}

//NlogN Sorting+BinarySearch Approach
class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class PointClustering {

    public static List<List<Point>> clusterPoints(List<Point> points, double d) {
        int n = points.size();

        // Sort points based on custom comparator
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x != p2.x) {
                    return Double.compare(p1.x, p2.x);
                } else {
                    return Double.compare(p1.y, p2.y);
                }
            }
        });

        // Initialize clusters list
        List<List<Point>> clusters = new ArrayList<>();

        // Traverse through sorted points
        for (Point point : points) {
            boolean added = false;

            // Binary search to find the appropriate cluster to add the point
            int low = 0, high = clusters.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                List<Point> cluster = clusters.get(mid);

                // Check if point can be added to this cluster
                if (canAddToCluster(cluster, point, d)) {
                    cluster.add(point);
                    added = true;
                    break;
                } else {
                    // Adjust search range based on distance
                    if (point.x - cluster.get(cluster.size() - 1).x > d) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }

            // If not added to any existing cluster, create a new cluster
            if (!added) {
                List<Point> newCluster = new ArrayList<>();
                newCluster.add(point);
                clusters.add(newCluster);
            }
        }

        return clusters;
    }

    private static boolean canAddToCluster(List<Point> cluster, Point point, double d) {
        for (Point p : cluster) {
            if (distance(p, point) <= d) {
                return true;
            }
        }
        return false;
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}


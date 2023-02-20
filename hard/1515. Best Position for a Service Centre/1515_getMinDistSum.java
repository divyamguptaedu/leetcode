class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public double getMinDistSum(int[][] positions) {
        double minimum_step = 0.0000001;
        double step = 50.0;
        double sum_x = 0;
        double sum_y = 0;
        int n = positions.length;
        for (int[] position : positions) {
            sum_x += position[0];
            sum_y += position[1];
        }
        sum_x = sum_x / n;
        sum_y = sum_y / n;
        Node center = new Node(sum_x, sum_y, totalDistance(positions, sum_x, sum_y));
        while (step > minimum_step) {
           Node minimum = center;
           for (int[] direction : directions) {
               double new_x = center.x + direction[0] * step;
               double new_y = center.y + direction[1] * step;
               double newDistance = totalDistance(positions, new_x, new_y);
               if (newDistance < center.distance) {
                   minimum = new Node(new_x, new_y, newDistance);
               }
           }
           if (center == minimum) {
               step = step / 2;
           }
           center = minimum;
        }
        return center.distance; 
    }

    private double calculateDistance(int[] position, double x, double y) {
        return Math.sqrt(square(x - position[0]) + square(y - position[1]));
    }

    private double square(double x) {
        return x * x;
    }

    private double totalDistance(int[][] positions, double x, double y) {
        double total_distance = 0;
        for (int[] position : positions) {
           total_distance +=  calculateDistance(position, x, y);
        }
        return total_distance;
    }

    private static class Node {
        double x;
        double y; 
        double distance;
        Node(double x, double y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }


}
//To solve the problem of finding the maximum number of intersections of an infinitely long horizontal line with a line chart, 
//I used a TreeMap to store the y-coordinates in ascending order. 
//For each y-coordinate, I tracked how many points are at that y, how many segments start above, 
//and how many segments end below. I then iterated through the sorted y-coordinates to calculate the maximum 
//intersections by considering the points above and below each y-coordinate.

//Time: O(n log n)
//Space: O(n)

class Solution {
    class Pair {
        int nPoints; // number of points at the same y-coordinate
        int above;   // number of segments starting above the current y-coordinate
        int below;   // number of segments ending below the current y-coordinate
    }

    public int maxIntersectionCount(int[] y) {
        TreeMap<Integer, Pair> yaxis = new TreeMap<>();
        int n = y.length;

        for (int i = 0; i < n; i++) {
            Pair pair = yaxis.getOrDefault(y[i], new Pair());
            if (i != 0) { // when i == 0, there's no y[i - 1]
                updateLines(pair, y[i], y[i - 1]);
            }
            if (i + 1 != n) { // when i == n - 1, there's no y[i + 1]
                updateLines(pair, y[i], y[i + 1]);
            }
            pair.nPoints++;
            yaxis.put(y[i], pair);
        }

        int answer = 0, soFar = 0;
        for (Map.Entry<Integer, Pair> entry : yaxis.entrySet()) {
            Pair pair = entry.getValue();
            soFar -= pair.below;
            answer = Math.max(soFar + pair.nPoints, answer);
            soFar += pair.above;
            answer = Math.max(soFar, answer);
        }
        return answer;
    }

    void updateLines(Pair pair, int current, int prevOrNext) {
        if (current < prevOrNext) {
            pair.above++;
        } else {
            pair.below++;
        }
    }
}

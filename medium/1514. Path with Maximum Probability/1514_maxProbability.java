class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new ArrayList[n];
        for (int i = 0;i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new double[]{edges[i][1], succProb[i]});
            graph[edges[i][1]].add(new double[]{edges[i][0], succProb[i]});
        }
        double[] probabilities = new double[n];
        probabilities[start] = 1.0;
        boolean[] visited = new boolean[n];
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(Collections.reverseOrder((a, b) -> Double.compare(a[1], b[1])));
        maxHeap.add(new double[]{start, 1.0});
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int currentVertex = (int) current[0];
            double currentProbability = current[1];
            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                for (double[] gedges: graph[currentVertex]) {
                    int next = (int) gedges[0];
                    double probability = gedges[1];
                    if (probabilities[next] < currentProbability * probability) {
                        probabilities[next] = currentProbability * probability;
                        maxHeap.add(new double[]{next, probabilities[next]});
                    }
                }
            }
        }
        return probabilities[end];
    }
}
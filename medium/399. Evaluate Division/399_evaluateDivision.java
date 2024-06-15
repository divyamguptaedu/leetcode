//I constructed a graph from the given equations where each variable is a node, and each equation is an edge with a weight equal to the quotient.
//For each query, I used Depth-First Search (DFS) to find a path from the dividend to the divisor, calculating the product of edge weights along the path.
//If no path existed, I returned -1.0.

//Time: (M*N) where n is the number of input equations and M is the num queries.
//Space: N
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Create a graph to store equations
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        // Step 1: Build the graph from the equations
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String numerator = equation.get(0);
            String denominator = equation.get(1);
            double quotient = values[i];

            // Add the numerator -> denominator edge
            graph.computeIfAbsent(numerator, k -> new HashMap<>()).put(denominator, quotient);
            // Add the denominator -> numerator edge
            graph.computeIfAbsent(denominator, k -> new HashMap<>()).put(numerator, 1 / quotient);
        }

        // Step 2: Evaluate each query using backtracking (DFS)
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String numerator = query.get(0);
            String denominator = query.get(1);

            // If either variable is not in the graph, return -1.0
            if (!graph.containsKey(numerator) || !graph.containsKey(denominator)) {
                results[i] = -1.0;
            // If both variables are the same, the result is 1.0
            } else if (numerator.equals(denominator)) {
                results[i] = 1.0;
            // Otherwise, perform DFS to find the path product
            } else {
                HashSet<String> visited = new HashSet<>();
                results[i] = backtrackEvaluate(graph, numerator, denominator, 1, visited);
            }
        }

        return results;
    }

    // Helper method to perform DFS and find the product of the path
    private double backtrackEvaluate(HashMap<String, HashMap<String, Double>> graph, String currentNode, String targetNode, double accumulatedProduct, Set<String> visited) {
        // Mark the current node as visited
        visited.add(currentNode);
        double result = -1.0;

        // Get neighbors of the current node
        Map<String, Double> neighbors = graph.get(currentNode);
        // If the target node is a direct neighbor, return the product
        if (neighbors.containsKey(targetNode)) {
            result = accumulatedProduct * neighbors.get(targetNode);
        } else {
            // Otherwise, visit each neighbor recursively
            for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nextNode = pair.getKey();
                if (visited.contains(nextNode)) continue; // Skip visited nodes
                // Recursively evaluate the path from the neighbor to the target
                result = backtrackEvaluate(graph, nextNode, targetNode, accumulatedProduct * pair.getValue(), visited);
                if (result != -1.0) break; // If a valid path is found, break
            }
        }

        // Unmark the current node for other paths
        visited.remove(currentNode);
        return result;
    }
}

//I created a directed graph using the given pairs, tracking incoming and outgoing
//edges for each node. I identified a starting node with more outgoing edges than
//incoming, ensuring a valid path. I then constructed an Eulerian path, repeatedly
//finding cycles and merging them into the main path. Each time a cycle was detected,
//it was inserted at the appropriate position in the existing path. 
//This approach guarantees that every pair is connected correctly, 
//forming a valid arrangement.

//Time: n
//Space: n
class Solution {
    // Helper class to represent a path in the graph
    public static class Path {
        public final int value;
        public Path next;
        public Path end;

        public Path(int value) {
            this.value = value;
        }

        public Path getNext() {
            Path endNode = this.end;
            if (next != null) {
                next.end = endNode;
            }
            return next;
        }

        public void insert(Path newPath) {
            Path temp = next;
            next = newPath;
            newPath.end.next = temp;
        }
    }

    public int[][] validArrangement(int[][] pairs) {
        // Maps to store incoming and outgoing edges for each node
        Map<Integer, LinkedList<Integer>> incomingEdges = new HashMap<>();
        Map<Integer, LinkedList<Integer>> outgoingEdges = new HashMap<>();
        
        // Populate the maps with the pairs
        for (int[] pair : pairs) {
            outgoingEdges.computeIfAbsent(pair[0], k -> new LinkedList<>()).add(pair[1]);
            incomingEdges.computeIfAbsent(pair[1], k -> new LinkedList<>()).add(pair[0]);
        }
        
        // Identify the starting node, which has more outgoing edges than incoming edges
        Path startNode = new Path(pairs[0][0]);
        for (Map.Entry<Integer, LinkedList<Integer>> entry : outgoingEdges.entrySet()) {
            LinkedList<Integer> inEdges = incomingEdges.get(entry.getKey());
            if (inEdges == null || entry.getValue().size() > inEdges.size()) {
                startNode = new Path(entry.getKey());
                break;
            }
        }
        
        // Construct the path starting from the start node
        Path currentPath = startNode;
        findCycle(currentPath, outgoingEdges);
        
        // Continue until all outgoing edges are processed
        while (!outgoingEdges.isEmpty()) {
            while (!outgoingEdges.containsKey(startNode.value)) {
                startNode = startNode.getNext();
            }
            Path newPath = new Path(startNode.value);
            if (findCycle(newPath, outgoingEdges)) {
                startNode.insert(newPath.getNext());
            } else {
                startNode.end.insert(newPath.getNext());
            }
        }
        
        // Fill the result array with the constructed path
        for (int i = 0; i < pairs.length; i++) {
            pairs[i][0] = currentPath.value;
            pairs[i][1] = currentPath.next.value;
            currentPath = currentPath.next;
        }
        
        return pairs;
    }

    // Helper method to find a cycle in the graph starting from the given node
    private boolean findCycle(Path startNode, Map<Integer, LinkedList<Integer>> outgoingEdges) {
        Path currentNode = startNode;
        LinkedList<Integer> nextNodes;
        while ((nextNodes = outgoingEdges.get(currentNode.value)) != null) {
            currentNode.next = new Path(nextNodes.poll());
            if (nextNodes.isEmpty()) {
                outgoingEdges.remove(currentNode.value);
            }
            currentNode = currentNode.getNext();
        }
        startNode.end = currentNode;
        return startNode.value == currentNode.value;
    }
}


//another solution

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Stack<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> outDegrees = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (int[] pair : pairs) {
            adjList.computeIfAbsent(pair[0], k -> new Stack<>()).add(pair[1]);
            outDegrees.put(pair[0], outDegrees.getOrDefault(pair[0], 0) + 1);
            inDegrees.put(pair[1], inDegrees.getOrDefault(pair[1], 0) + 1);
        }

        int start = pairs[0][0];

        for (int node : adjList.keySet()) {
            int out = outDegrees.getOrDefault(node, 0);
            int in = inDegrees.getOrDefault(node, 0);
            if (out > in) {
                start = node;
                break;
            }
        }

        List<Integer> path = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int u = stack.peek();
            if (adjList.containsKey(u) && !adjList.get(u).isEmpty()) {
                stack.push(adjList.get(u).pop());
            } else {
                path.add(stack.pop());
            }
        }

        int[][] result = new int[path.size() - 1][2];
        for (int i = path.size() - 1; i > 0; i--) {
            result[path.size() - 1 - i][0] = path.get(i);
            result[path.size() - 1 - i][1] = path.get(i - 1);
        }

        return result;
    }
}

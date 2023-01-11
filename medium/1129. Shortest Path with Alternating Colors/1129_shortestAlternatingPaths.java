class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer, List<Integer>> redMap = new HashMap<>();
        HashMap<Integer, List<Integer>> blueMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            redMap.put(i, new ArrayList<>());
            blueMap.put(i, new ArrayList<>());
        }

        for (int[] redEdge : redEdges) {
            int source = redEdge[0];
            int desti = redEdge[1];
            redMap.get(source).add(desti);
        }

        for (int[] blueEdge : blueEdges) {
            int source = blueEdge[0];
            int desti = blueEdge[1];
            blueMap.get(source).add(desti);
        }

        int steps = 0;
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[] paths = new int[n];
        Arrays.fill(paths, Integer.MAX_VALUE);

        queue.add(new Pair(0, 0));
        queue.add(new Pair(0, 1));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> current = queue.poll();
                visited.add(current);
                int currentNode = current.getKey();
                int currentColor = current.getValue();

                if (currentColor == 0) {
                    paths[currentNode] = Math.min(paths[currentNode], steps);
                    for (int blueCurrentEdge : blueMap.get(currentNode)) {
                        Pair<Integer, Integer> newPair = new Pair(blueCurrentEdge, 1);
                        if (!visited.contains(newPair)) {
                            queue.add(newPair);
                        }
                    }
                } else {
                    paths[currentNode] = Math.min(paths[currentNode], steps);
                    for (int redCurrentEdge : redMap.get(currentNode)) {
                        Pair<Integer, Integer> newPair = new Pair(redCurrentEdge, 1);
                        if (!visited.contains(newPair)) {
                            queue.add(newPair);
                        }
                    }
                }
            }
            steps++;
        }
        for (int i = 0; i < paths.length; i++) {
            if (paths[i] == Integer.MAX_VALUE) {
                paths[i] = -1;
            }
        }
        return paths;

    }
}
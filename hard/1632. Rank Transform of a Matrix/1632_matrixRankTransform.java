class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rank = new int[n + m];

        //address dictionary
        Map<Integer, List<int[]>> d = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = matrix[i][j];
                d.putIfAbsent(val, new ArrayList<>());
                d.get(val).add(new int[]{i, j});
            }
        }

        for (int x : d.keySet()) {
            DSU dsu = new DSU();

            // linearize
            for (int[] pair : d.get(x)) {
                int i = pair[0];
                int j = pair[1] + n;
                dsu.add(i);
                dsu.add(j);
            }

            // unite elements in row and col
            for (int[] pair : d.get(x)) {
                int i = pair[0];
                int j = pair[1] + n;
                dsu.unite(i, j);
            }

            Map<Integer, List<Integer>> groups = dsu.getGroups();

            //assign ranks
            for (List<Integer> group : groups.values()) {
                int maxRank = 0;
                for (int location : group) {
                    maxRank = Math.max(maxRank, rank[location]);
                }
                for (int location : group) {
                    rank[location] = maxRank + 1;
                }
            }

            //change values to their rank
            for (int[] pair : d.get(x)) {
                int i = pair[0];
                int j = pair[1];
                matrix[i][j] = rank[i];
            }
        }

        return matrix;
    }
}

class DSU {
    Map<Integer, Integer> parent;
    Map<Integer, Integer> size;

    public DSU() {
        parent = new HashMap<>();
        size = new HashMap<>();
    }

    public void add(int x) {
        parent.put(x, x);
        size.put(x, 1);
    }

    public int find(int x) {
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (size.get(y) < size.get(x)) {
            int temp = x;
            x = y;
            y = temp;
        }
        size.put(y, size.get(y) + size.get(x));
        parent.put(x, y);
    }

    public Map<Integer, List<Integer>> getGroups() {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int x : parent.keySet()) {
            int root = find(x);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(x);
        }
        return groups;
    }
}
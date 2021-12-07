class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        LinkedList<Integer> linkedListItems = new LinkedList<>();
        int[] seen = new int[n];
        for (int i = 0; i < n; i++) {
            if (seen[i] == 2) {
                continue;
            }
            if (!helper(beforeItems, seen, linkedListItems, i)) {
                return new int[0];
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        List<List<Integer>> previousList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            previousList.add(new ArrayList<>());
        }
        Map<Integer,Set<Integer>> temp = new HashMap<>();//use treemap to maintain group information
        for (int i = 0; i < n; i++) {
            temp.putIfAbsent(group[i], new HashSet<>());
            for (int x : beforeItems.get(i)) {
                if (group[i] != group[x]) {
                    temp.get(group[i]).add(group[x]);
                }
            }
        }
        
        for (Map.Entry<Integer, Set<Integer>> z : temp.entrySet()){
            List<Integer> tempList = previousList.get(z.getKey());
            tempList.addAll(z.getValue());
        }
        
        LinkedList<Integer> result = new LinkedList<>();
        int[] seenGroups = new int[m];
        for (int i = 0; i < m; i++) {
            if (seenGroups[i] == 2) {
                continue;
            }
            if(!helper(previousList, seenGroups, result, i)) {
                return new int[0];
            }
        }
        
        List<Integer>[] listItems = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            listItems[i] = new ArrayList<Integer>();
        }
        for (int i : result) {
            listItems[group[i]].add(i);
        }
        
        int[] resultFinal = new int[n];
        int i = 0;
        for (int g: groupRes) {
            for(int item : listItems[g]) {
                resultFinal[i++] = item;
            }
        }
        return resultFinal;
    }
    
    private boolean helper(List<List<Integer>> beforeItems, int[] visited, List<Integer> result, int index) {
        visited[index] = 1;
        List<Integer> current = beforeItems.get(index);
        for (int i : current) {
            if (visited[i] == 1) {
                return false;
            }
            if (visited[i] == 0) {
                if (!helper(beforeItems, visited, result, i)) {
                    return false;
                }
            }
        }
        visited[index] = 2;
        result.add(index);
        return true;
    }

}
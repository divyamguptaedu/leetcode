class Solution {
    Map<Integer, List<Integer>> map;
    List<Integer> result;
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        map = new HashMap<>();
        result = new ArrayList<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) != 0) {
                if (!map.containsKey(ppid.get(i))) map.put(ppid.get(i), new ArrayList<>());
                map.get(ppid.get(i)).add(pid.get(i));
            }
        }
        //3: 1 and 5, 5: 10
        result.add(kill);
        dfs(kill);
        return result;
    }

    private void dfs(int kill) {
        if (map.get(kill) != null) {
            List<Integer> children = map.get(kill);
            for (Integer i : children) {
                result.add(i);
                dfs(i);
            }
        }
    }
}
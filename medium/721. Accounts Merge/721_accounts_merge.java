"""
Performance:
Runtime: 39 ms, faster than 50.24% of Java online submissions for Accounts Merge.
Memory Usage: 51.3 MB, less than 13.47% of Java online submissions for Accounts Merge.
"""

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> nameMap = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> emails = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (List<String> account : accounts){
            String name = account.get(0);
            for (int i = 1; i < account.size(); ++i){
                String email = account.get(i);
                nameMap.put(email, name);
                emails.add(email);
                graph.putIfAbsent(email, new HashSet<>());
                if (i == 1)
                    continue;
                graph.get(email).add(account.get(i-1));
                graph.get(account.get(i-1)).add(email);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String email : emails){
            if (visited.contains(email))
                continue;
            List<String> temp = new ArrayList<>();
            helper(email, graph, visited, temp);
            Collections.sort(temp);
            temp.add(0, nameMap.get(email));
            result.add(temp);   
        }
        return result;
    }
    
    private void helper(String cur, Map<String, Set<String>> graph, Set<String> visited, List<String> temp){
        if (visited.contains(cur)) {
            return;
        }
        visited.add(cur);
        temp.add(cur);
        for (String email : graph.get(cur)) {
            helper(email, graph, visited, temp);
        }
    }
}
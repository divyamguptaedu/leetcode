//Created the adj list, traversed over the accounts to check if the first email was already visited, 
//if not, performed DFS. During DFS, stored the emails in an array, marked as visited. 
//In the end, sorted the emails, added account name at start, returned the answer list.
//Time: O(NM log(NM)) where N is the number of people, and M is the maximum number of accounts they have.
//Space: O(NM)
class Solution {
    HashMap<String, List<String>> adjList = new HashMap<>();
    Set<String> visited = new HashSet<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            String firstEmail = account.get(1); //can take any email, the point is to connect them all.
            int accountSize = account.size();
            for (int index = 2; index < accountSize; index++) { //connect all the accounts
                String email = account.get(index);
                if (!adjList.containsKey(firstEmail)) {
                    adjList.put(firstEmail, new ArrayList<String>());
                }
                adjList.get(firstEmail).add(email);
                if (!adjList.containsKey(email)) {
                    adjList.put(email, new ArrayList<>());
                }
                adjList.get(email).add(firstEmail);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            if (!visited.contains(firstEmail)) {
                ArrayList<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(name);
                DFS(mergedAccount, firstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                result.add(mergedAccount);
            }
        }

        return result;
    }

    private void DFS(List<String> mergedAccount, String email) {
        visited.add(email);
        mergedAccount.add(email);
        if (!adjList.containsKey(email)) {
            return;
        }
        for (String otherEmail : adjList.get(email)) {
            if (!visited.contains(otherEmail)) {
                DFS(mergedAccount, otherEmail);
            }
        }
    }
}
import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parents = new int[accounts.size()];

        for (int i = 0; i < accounts.size(); i++) {
            parents[i] = i;
        }

        HashMap<String, Integer> owners = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (owners.containsKey(email)) {
                    int person = owners.get(email);
                    int p1 = findParent(i, parents);
                    int p2 = findParent(person, parents);
                    if (p1 != p2) {
                        parents[p2] = p1;
                    }
                } else {
                    owners.put(email, i);
                }
            }
        }

        HashMap<Integer, TreeSet<String>> users = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            int parent = findParent(i, parents);
            users.putIfAbsent(parent, new TreeSet<>());
            List<String> emails = accounts.get(i);
            users.get(parent).addAll(emails.subList(1, emails.size()));
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, TreeSet<String>> e : users.entrySet()) {
            String user = accounts.get(e.getKey()).get(0);
            TreeSet<String> emails = e.getValue();
            List<String> temp = new ArrayList<>();
            temp.add(user);
            temp.addAll(emails);
            result.add(temp);
        }
        return result;
    }

    private int findParent(int current, int[] parents) {
        if (parents[current] == current) {
            return current;
        }
        parents[current] = findParent(parents[current], parents);
        return parents[current];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<String>> accounts1 = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")
        );

        List<List<String>> result1 = solution.accountsMerge(accounts1);
        System.out.println("Merged accounts (Test 1): " + result1);

        List<List<String>> accounts2 = Arrays.asList(
                Arrays.asList("Alex", "alex5@mail.com", "alex7@mail.com"),
                Arrays.asList("Alex", "alex3@mail.com", "alex5@mail.com"),
                Arrays.asList("Alex", "alex2@mail.com"),
                Arrays.asList("Alex", "alex4@mail.com", "alex2@mail.com")
        );

        List<List<String>> result2 = solution.accountsMerge(accounts2);
        System.out.println("Merged accounts (Test 2): " + result2);
    }
}

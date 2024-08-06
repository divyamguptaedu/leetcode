//Created an adj list and a list tracking the number of edges coming in each node. 
//Built the graph and increment the elements in the numEdgesComingIn by comparing two words 
//and finding the char that makes the word less than other. 
//Then pushed all indices of numEdgesComingIn == 0 to a queue and started BFS. 
//In BFS, poll and save to current, append the char to order by passing its correct ascii value. 
//Updated the current's neighbors by decreasing numEdges by 1 and pushed to queue if new is 0.
//Time: O(n)
//Space: O(n)
class Solution {
    public String alienOrder(String[] words) {
        List<Integer>[] graph = new List[26];
        int[] numEdgesComingIn = new int[26];
        for (int i = 0; i < 26; i++) {
            numEdgesComingIn[i] = -1;
            graph[i] = new ArrayList<>();
        }
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                numEdgesComingIn[c - 'a'] = 0;
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            
            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    graph[first.charAt(j) - 'a'].add(second.charAt(j) - 'a');
                    numEdgesComingIn[second.charAt(j) - 'a']++;
                    break;
                }
            }
        }

        int total = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (numEdgesComingIn[i] == 0) {
                q.offer(i);
            }
            
            if(numEdgesComingIn[i] != -1) {
                total++;
            }
        }
        
        StringBuilder order = new StringBuilder();
        while (!q.isEmpty()) {
            int curr = q.poll();
            order.append((char)(curr + 'a'));
            
            for (int neighbor : graph[curr]) {
                numEdgesComingIn[neighbor]--;
                if (numEdgesComingIn[neighbor] == 0) {
                    q.offer(neighbor);          
                }
            }
        }

        return order.length() < total ? "" : order.toString();
    }
}


//another solution
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> numEdgesComingIn = new HashMap<>();
        for (String word : words) {
            for (Character ch : word.toCharArray()) {
                adjList.put(ch, new ArrayList<>());
                numEdgesComingIn.put(ch, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    numEdgesComingIn.put(word2.charAt(j), numEdgesComingIn.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        Queue<Character> queueOfNextChars = new LinkedList<>();
        for (Character ch : numEdgesComingIn.keySet()) {
            if (numEdgesComingIn.get(ch).equals(0)) {
                queueOfNextChars.add(ch);
            }
        }
        while (!queueOfNextChars.isEmpty()) {
            Character ch = queueOfNextChars.poll();
            result.append(ch);
            for (Character neighbor : adjList.get(ch)) {
                numEdgesComingIn.put(neighbor, numEdgesComingIn.get(neighbor) - 1);
                if (numEdgesComingIn.get(neighbor).equals(0)) {
                    queueOfNextChars.add(neighbor);
                }
            }
        }
        if (result.length() < numEdgesComingIn.size()) {
            return "";
        }
        return result.toString();
    }
}
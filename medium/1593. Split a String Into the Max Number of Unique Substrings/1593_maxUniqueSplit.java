class Solution {

    int maximumSplits = 0;
    String s_temp;
    
    public int maxUniqueSplit(String s) {
        maximumSplits = 0;
        s_temp = s;
        HashSet<String> visitedSet = new HashSet<>();
        maxSplitCalculate(visitedSet, 0);
        return maximumSplits;
    }

    private void maxSplitCalculate(HashSet<String> visited, int start) {
        if (start == s_temp.length()) {
            maximumSplits = Math.max(maximumSplits, visited.size());
        }
        for (int end = start + 1; end <= s_temp.length(); end++) {
            String s_sub = s_temp.substring(start, end);
            if (!visited.contains(s_sub)) {
                visited.add(s_sub);
                maxSplitCalculate(visited, end);
                visited.remove(s_sub);
            }
        }
    }
}
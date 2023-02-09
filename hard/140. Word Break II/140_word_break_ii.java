class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet set = new HashSet();
        boolean[] dp =  new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        List result = new ArrayList();
        recursion("", result, 0, s, dp, set);
        return result;
    }
    
    private void recursion(String path, List<String> result, int index, String s, boolean[] dp, Set set) {
        if (index == s.length()) {
            result.add(path);
            return;
        }
        for (int j = index; j <= s.length(); j++) {
            if (dp[index] && set.contains(s.substring(index, j))) {
                dp[j] = true;
                String temp = path;
                path += s.substring(index, j);
                if (j != s.length()) {
                    path += " ";
                }
                recursion(path, result, j, s, dp, set);
                path = temp;
            }
        }
    }
}
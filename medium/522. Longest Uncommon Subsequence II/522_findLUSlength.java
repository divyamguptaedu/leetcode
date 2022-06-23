"
Performance:
Runtime: 3 ms, faster than 37.40% of Java online submissions for Longest Uncommon Subsequence II.
Memory Usage: 41.4 MB, less than 65.45% of Java online submissions for Longest Uncommon Subsequence II.
"

class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (x, y) -> y.length() - x.length());
        Map<String,Integer> hashMap = new HashMap<>();
        for (String str : strs) {
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
        }
        
        for (int i = 0; i < strs.length; i++) { 
            if (hashMap.get(strs[i]) != 1) {
                continue;
            }
            int temp;
            for (temp = 0; temp < i; temp++) {
                if (isSubsequence(strs[i], strs[temp])) {
                    break;
                }
            }
             if (temp == i) {
                 return strs[i].length();
             }
        }
        return -1;
    }
    public boolean isSubsequence(String a, String b){
        int i = 0;
        int temp = 0;
        while (i < a.length() && temp < b.length()) {
            if (a.charAt(i) == b.charAt(temp++)) {
                i++;
            }
        }
        return i == a.length();
    }
}
"""
Performance:
Runtime: 10 ms, faster than 90.58% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
Memory Usage: 39.2 MB, less than 99.57% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
"""

class Solution {
    private int N = 26;
    public int minDeletions(String s) {
        int[] array = new int[N];
        for (char ch : s.toCharArray()) {
            array[ch - 'a']++;
        }
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            if (i == 0) continue;
            while (set.contains(i)) {
                i--;
                ans++;
            }
            if (i != 0) {
                set.add(i);
            }
        }
        return ans;
    }
}
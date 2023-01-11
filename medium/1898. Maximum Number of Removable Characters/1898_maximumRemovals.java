class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        int l = 0;
        int r = removable.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            for (int i = l; i <= mid; i++) {
                sChar[removable[i]] = '*';
            }
            if (helper(sChar, pChar)) {
                l = mid + 1;
            } else {
                for (int i = l; i <= mid; i++) {
                    sChar[removable[i]] = s.charAt(removable[i]);
                }
                r = mid - 1;
            }
        }
        return r + 1;
    }

    public boolean helper(char[] s, char[] p){
        int i = 0;
        int j = 0;
        while (i < s.length && j < p.length) {
            if (s[i] == p[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == p.length;
    }
}
class Solution {
    List<String> ansList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        solve(0, s, new StringBuilder(""));
        return ansList;
    }
    
    boolean isValid(String s) {
        if (s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0'))
            return false;
        int val = Integer.valueOf(s);
        return val >= 0 && val <= 255;
    }

    void solve(int depth, String s, StringBuilder sb) {
        if (depth == 3) {
            if (isValid(s)) {
                sb.append(s);
                ansList.add(sb.toString());
                sb.setLength(sb.length() - s.length());
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (i >= s.length())
                break;
            String temp = s.substring(0, i);
            if (isValid(temp)) {
                sb.append(temp).append(".");
                solve(depth + 1, s.substring(i), sb);
                sb.setLength(sb.length() - (temp.length() + 1));
            }
        }
    }
}
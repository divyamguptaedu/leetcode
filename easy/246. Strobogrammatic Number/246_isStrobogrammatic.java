//Time: O(n)
//Space: O(n)
class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c == '0' || c == '1' || c == '8') {
                sb.append(c);
            } else if (c == '6') {
                sb.append('9');
            } else if (c == '9') {
                sb.append('6');
            } else {
                return false;
            }
        }
        
        String result = sb.toString();
        return num.equals(result);
    }
}
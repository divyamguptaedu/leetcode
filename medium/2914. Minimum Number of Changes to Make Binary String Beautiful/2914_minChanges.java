class Solution {
    public int minChanges(String s) {
        int length = s.length();
        int count = 0;
        for (int i = 0; i < lrmgth; i += 2) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            if (first != second) {
                count++;
            }
        }
        return count;
    }
}
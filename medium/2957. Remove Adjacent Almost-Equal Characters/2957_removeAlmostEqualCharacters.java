class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int count = 0;
        for (int i = 0; i < word.length() - 1;) {
            char first = word.charAt(i);
            char second = word.charAt(i + 1);
            if (first == second || (first + 1) == second || (first - 1) == second) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count;
    }
}
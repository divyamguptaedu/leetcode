"
Performance:
Runtime: 1 ms, faster than 88.35% of Java online submissions for Compare Version Numbers.
Memory Usage: 40.2 MB, less than 89.44% of Java online submissions for Compare Version Numbers.
"

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] versionOne = version1.split("\\.");
        String[] versionTwo = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i< versionOne.length || j < versionTwo.length) {
            int revisionOne = i>= versionOne.length ? 0 : Integer.parseInt(versionOne[i]);
            int revisionTwo = j>= versionTwo.length ? 0 : Integer.parseInt(versionTwo[j]);
            if (revisionOne < revisionTwo) {
                return -1;
            } else if (revisionOne > revisionTwo) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }
}
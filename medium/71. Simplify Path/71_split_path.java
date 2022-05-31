"""
Performance:
Runtime: 4 ms, faster than 90.85% of Java online submissions for Simplify Path.
Memory Usage: 42.6 MB, less than 79.73% of Java online submissions for Simplify Path.
"""

class Solution {
    public String simplifyPath(String path) {
        String[] pathSplit = path.split("/");
        List<String> temp = new ArrayList<>();
        for (String pathSplitUnit : pathSplit) {
            if (pathSplitUnit.equals(".")) {
                pathSplitUnit = "";
            } else if (pathSplitUnit.equals("..")) {
                if (temp.size() > 0) {
                    temp.remove(temp.size() - 1);
                }
                pathSplitUnit = "";
            }
            if (!pathSplitUnit.equals("")) {
                temp.add(pathSplitUnit);
            }
        }
        
        StringBuilder result = new StringBuilder();
        result.append("/");
        result.append(String.join("/", temp));
        
        return result.toString();
    }
}
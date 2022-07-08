"
Performance:
Runtime: 17 ms, faster than 16.33% of Java online submissions for Swap Adjacent in LR String.
Memory Usage: 48.5 MB, less than 6.91% of Java online submissions for Swap Adjacent in LR String.
"

class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X","").equals(end.replace("X",""))) {
            return false;
        }
        if (start.length() > end.length() || end.length() > start.length()) {
            return false;
        }
        ArrayList<Integer> leftStart = new ArrayList<>(); 
        ArrayList<Integer> leftEnd = new ArrayList<>(); 
        ArrayList<Integer> rightStart = new ArrayList<>(); 
        ArrayList<Integer> rightEnd = new ArrayList<>(); 
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                leftStart.add(i);
            }
            if (start.charAt(i) == 'R') {
                rightStart.add(i);
            }
        }
        for (int i = 0; i < end.length(); i++) {
            if (end.charAt(i) == 'L') {
                leftEnd.add(i);
            }
            if (end.charAt(i) == 'R') {
                rightEnd.add(i);
            }
        }
        int i = 0;
        int j = 0;
        while (i < leftStart.size() && j <  leftEnd.size()) {
            if (leftEnd.get(j) > leftStart.get(i)) {
                return false;
            }
            i++;
            j++;
        }
        i = 0; 
        j = 0;
        while (i < rightStart.size() && j < rightEnd.size()) {
            if (rightEnd.get(j) < rightStart.get(i)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
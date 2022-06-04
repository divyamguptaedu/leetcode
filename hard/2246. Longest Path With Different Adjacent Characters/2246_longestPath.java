/*
Runtime: 181 ms, faster than 48.59% of Java online submissions for Longest Path With Different Adjacent Characters.
Memory Usage: 163 MB, less than 11.94% of Java online submissions for Longest Path With Different Adjacent Characters.
*/

class Solution {
    public int longestPath(int[] parent, String s) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            result.add(new ArrayList<Integer>());
        }
        for (int i = 1; i < parent.length; i++) {
            result.get(parent[i]).add(i);
        }
        Pair temp = helper(0, result, s);
        return temp.maximum;
    }
    public Pair helper(int root, ArrayList<ArrayList<Integer>> result, String s) {
        if (result.get(root).size() == 0) {
            return new Pair(1,1);
        }
        int maximum = 0;
        int tempOne = 0;
        int tempTwo = 0;
        for (int child : result.get(root)) {
            Pair pair = helper(child, result, s);
            maximum = Math.max(maximum, pair.maximum);
            if (s.charAt(root) != s.charAt(child)) {
                if (tempOne < pair.temp) {
                    tempTwo = tempOne;
                    tempOne = pair.temp;
                } else if (pair.temp > tempTwo) {
                    tempTwo = pair.temp;
                }
            }
        }
        maximum = Math.max(maximum, tempOne + tempTwo + 1);
        return new Pair(tempOne + 1, maximum);
    }
    class Pair{
        int temp;
        int maximum;
        Pair(int temp, int maximum) {
            this.temp = temp;
            this.maximum = maximum;
        }
    }
}
/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
Memory Usage: 36.8 MB, less than 74.50% of Java online submissions for Pascal's Triangle.
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        list.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            list.add(new ArrayList<Integer>());
            list.get(i).add(1);
            for (int index = 0; index < i - 1; index++) {
                list.get(i).add(list.get(i - 1).get(index) + list.get(i - 1).get(index + 1));
            }
            list.get(i).add(1);
        }
        return list;
    }
}
/*
Runtime: 4 ms, faster than 96.75% of Java online submissions for Powerful Integers.
Memory Usage: 42 MB, less than 48.28% of Java online submissions for Powerful Integers.
*/

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int xBound = 0;
        int yBound = 0;
        int value = 0;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        if (x == 1) {
            xBound = x;
        } else { 
            while (value < bound) {
                value = (int) Math.pow(x , xBound++);
            }
        }
        value = 0;
        if (y == 1) {
            yBound = y;
        } else {
            while (value < bound) {
                value = (int) Math.pow(y , yBound++);
            }
        }
        value = 0;
        for (int i = 0; i < xBound; i++) {
            for (int j = 0; j < yBound; j++) {
                value = (int) Math.pow(x , i) + (int) Math.pow(y , j);
                if (value <= bound) {
                    map.put(value , 0);
                } else {
                    break;
                }
            }
        }
        for (int key : map.keySet()){
            result.add(key);
        }
        return result;
    }
}
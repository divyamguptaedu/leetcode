"
Performance:
Runtime: 31 ms, faster than 16.36% of Java online submissions for Maximum Candies You Can Get from Boxes.
Memory Usage: 105.4 MB, less than 6.36% of Java online submissions for Maximum Candies You Can Get from Boxes.
"

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int result = 0;

        if (initialBoxes.length == 0) {
            return 0;
        }
        int length = status.length;
        Queue<Integer> list = new LinkedList<>();
        
        boolean[] updateBox = new boolean[length];
        boolean[] updateKeys = new boolean[length];
        boolean[] visitedBox = new boolean[length];
    
        for (int box : initialBoxes) {
            if (status[box] == 1) {
                list.offer(box);
            }
            updateBox[box] = true;
        }
        
        while (!list.isEmpty()) {
            int size = list.size();
            while (size > 0) {
                int box = list.poll();
                if (!visitedBox[box]) {
                    visitedBox[box] = true;
                    result += candies[box];
                    for (int containBox : containedBoxes[box]) {
                        updateBox[containBox] = true;
                        if (updateKeys[containBox] || status[containBox] == 1) {
							list.offer(containBox);
						}
                    }
                    for (int key : keys[box]) {
                        updateKeys[key] = true;
                        if (updateBox[key])  {
							list.offer(key);
						}
                    }
                }
                size--;
            }
        }
        return result;
    }
}
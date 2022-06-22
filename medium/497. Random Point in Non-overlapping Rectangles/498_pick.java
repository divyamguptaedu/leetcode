"
Performance:
Runtime: 114 ms, faster than 19.63% of Java online submissions for Random Point in Non-overlapping Rectangles.
Memory Usage: 68.4 MB, less than 38.65% of Java online submissions for Random Point in Non-overlapping Rectangles.
"

class Solution {
    Random random;
    TreeMap<Integer,int[]> hashMap;
    int total = 0;
    public Solution(int[][] rects) {
        this.random = new Random();
        this.hashMap = new TreeMap<>();
        for(int i = 0; i < rects.length; i++){
            int [] rectangeCoordinates = rects[i];
            int length = rectangeCoordinates[2] - rectangeCoordinates[0] + 1;
            int breadth = rectangeCoordinates[3] - rectangeCoordinates[1] + 1;
            total += length * breadth;
            hashMap.put(total,rectangeCoordinates);
        }
    }
    public int[] pick() {
        int key = hashMap.ceilingKey(random.nextInt(total) + 1);
        int[] rectangle = hashMap.get(key);
        int length = rectangle[2] - rectangle[0] + 1 ;
        int breadth = rectangle[3] - rectangle[1] + 1 ;
        int xCord = rectangle[0] + random.nextInt(length);
        int yCord = rectangle[1] + random.nextInt(breadth);
        return new int[] {xCord, yCord};
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
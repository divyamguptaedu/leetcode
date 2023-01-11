class Solution {
    
    Random random;
    TreeMap<Integer,int[]> map;
    int areaSum = 0;
    
    public Solution(int[][] rects) {
        this.random = new Random();
        this.map = new TreeMap<>();
        
        for (int i = 0; i < rects.length; i++) {
            int [] rectangeCoordinates = rects[i];
            int l = rectangeCoordinates[2] - rectangeCoordinates[0] + 1 ;
            int b = rectangeCoordinates[3] - rectangeCoordinates[1] + 1 ;
            areaSum += l * b;
            map.put(areaSum,rectangeCoordinates);
            
        }
        
    }
    
    public int[] pick() {
        int key = map.ceilingKey(random.nextInt(areaSum) + 1);
        int [] rectangle = map.get(key);
        int l = rectangle[2] - rectangle[0] + 1 ;
        int b = rectangle[3] - rectangle[1] + 1 ;
        int x = rectangle[0] + random.nextInt(l);
        int y = rectangle[1] + random.nextInt(b);
        return new int[]{x,y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
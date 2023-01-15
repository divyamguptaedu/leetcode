class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(i+1,new ArrayList<>());
        }
        for (int[] arr:paths) {
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }
        int[] colors = new int[n];
        ArrayList<Integer> choice = new ArrayList<>(Arrays.asList(1,2,3,4));
        map.forEach((k,v) -> {
            if (colors[k - 1] == 0){
                for (int i = 0; i < choice.size(); i++) {
                    if (isSafe(k, choice.get(i), map, colors)) {
                        colors[k - 1] = choice.get(i);
                        break;
                    }
                }
            }
        });
        return colors;
    }
    private boolean isSafe(int k,int c,Map<Integer,ArrayList<Integer>> map,int[] col){
        ArrayList<Integer> list = map.get(k);
        for (int item : list) {
            if (col[item - 1] == c) {
                return false;
            }
        }
        return true;
    }
}
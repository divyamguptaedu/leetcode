class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] result = arr.clone();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int rank = 1;

        if (arr.length == 0) {
            return arr;
        }
        
        int prev = arr[0];
        
        for (int num : arr) {
            if (prev != num) {
                rank++;
            }
            map.putIfAbsent(num, rank);
            prev = num;
        }
        
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(result[i]);
        }
        
        return result;
    }
}
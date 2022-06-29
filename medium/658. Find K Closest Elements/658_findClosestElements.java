"
Performance:
Runtime: 8 ms, faster than 53.13% of Java online submissions for Find K Closest Elements.
Memory Usage: 62.2 MB, less than 63.88% of Java online submissions for Find K Closest Elements.
"

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();  
        int low = 0;                                    
        int high = arr.length - 1;                      
        while(high - low >= k) {                         
            int distanceLow = Math.abs(arr[low] - x);
            int distanceHigh = Math.abs(arr[high] - x);
            if (distanceLow <= distanceHigh) {               
                high--;
            } else {                                     
                low++;     
            }
        }
        while (low <= high) {                            
            list.add(arr[low++]);  
        }
        return list;
    }
}
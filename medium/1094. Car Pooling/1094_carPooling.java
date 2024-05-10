//One solution is to go through the start to end, check if the capacity exceeds. We will just need the number
//of passengers changed at each timestamp. We can save the number changed each time, sort it by timestamp using
//a pq and finally iterate to check the actual capacity. However, it will be a nlogn approach.
// class Solution {
//     public boolean carPooling(int[][] trips, int capacity) {
//         Map<Integer, Integer> timestamp = new TreeMap<>();
//         for (int[] trip : trips) {
//             int startPassenger = timestamp.getOrDefault(trip[1], 0) + trip[0];
//             timestamp.put(trip[1], startPassenger);

//             int endPassenger = timestamp.getOrDefault(trip[2], 0) - trip[0];
//             timestamp.put(trip[2], endPassenger);
//         }
//         int usedCapacity = 0;
//         for (int passengerChange : timestamp.values()) {
//             usedCapacity += passengerChange;
//             if (usedCapacity > capacity) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

//Look at the 4th constraint in the problem which says that the distance of a trip will be between 0 and 1000.
//That means that if we create 1001 buckets, each representing each distance, and we keep a record of how
//many passengers are getting in and getting out at each km, then we can later just sum and see if it's we 
//ever crossed the capacity. So, this becomes a O(max(N, 1001)) approach. 

//Time: O(max(N, 1001))
//Space: O(1001) = O(1)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }
        int usedCapacity = 0;
        for (int number : timestamp) {
            usedCapacity += number;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}
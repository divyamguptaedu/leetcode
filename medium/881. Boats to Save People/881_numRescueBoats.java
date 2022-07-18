"
Performance:
Runtime: 20 ms, faster than 69.88% of Java online submissions for Boats to Save People.
Memory Usage: 65 MB, less than 72.07% of Java online submissions for Boats to Save People.
"

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int numBoats = 0;
        int leftPointer = 0;
        int rightPointer = people.length - 1;
        while (leftPointer <= rightPointer){
            int sum = people[leftPointer] + people[rightPointer];
            if (sum <= limit) {
                numBoats++;
                leftPointer++;
                rightPointer--;
            } else {
                numBoats++;
                rightPointer--;
            }
        }
        return numBoats;
    }
}
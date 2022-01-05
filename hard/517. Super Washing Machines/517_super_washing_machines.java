"
Performance:
Runtime: 1 ms, faster than 78.26% of Java online submissions for Super Washing Machines.
Memory Usage: 42.7 MB, less than 21.74% of Java online submissions for Super Washing Machines.
"

class Solution {
    public int findMinMoves(int[] machines) {
        
        int length = machines.length;
        int total = 0;
        int currentLot = 0;
        int totalLot = 0;
        int maximum = 0;
        
        for (int lot : machines) {
            total += lot;
        }
        
        if (total % length != 0) {
            return -1;
        }
        
        int average = total / length;
        
        for (int lot: machines){
            currentLot = lot - average;
            totalLot = totalLot + currentLot; 
            maximum = Math.max(currentLot, Math.max(maximum, Math.abs(totalLot)));
        }
        return maximum;
    }
}
//I tracked the total net gain and current net gain of gas minus cost as I iterated through the 
//gas stations. The totalGain variable accumulated the net gain for the entire trip, 
//while currGain tracked the net gain for the current segment of the trip. 
//If currGain became negative, I reset it to zero and set the starting station to the next station. 
//If the totalGain was non-negative after the loop, 
///it meant the trip was possible from the stored starting station; otherwise, 
//it wasn't possible to complete the circuit.

//Time: n
//Space: constant
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currGain = 0;
        int totalGain = 0;
        int answer = 0;

        for (int i = 0; i < gas.length; ++i) {
            // gain[i] = gas[i] - cost[i]
            totalGain += gas[i] - cost[i];
            currGain += gas[i] - cost[i];

            // If we meet a "valley", start over from the next station
            // with 0 initial gas.
            if (currGain < 0) {
                answer = i + 1;
                currGain = 0;
            }
        }

        return totalGain >= 0 ? answer : -1;
    }
}
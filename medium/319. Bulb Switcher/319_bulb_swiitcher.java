//I solved the problem by recognizing a pattern in how bulbs are toggled. 
//Each bulb is toggled in rounds that are its divisors. 
//Thus, a bulb ends up on if it has an odd number of divisors, 
//which occurs only for perfect squares. 
//Therefore, the number of bulbs that remain on after n rounds is equal to 
//the number of perfect squares less than or equal to n. 
//This can be found by taking the integer part of the square root of n.
//Time: constant
//Space: constant
class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
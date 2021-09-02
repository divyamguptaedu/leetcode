/*
1. Iterate over both the arrays and find XOR (^=) of the sum and the value.
2. Just do bitwise AND of the two sum and return.
*/

class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
         int sumOne = 0;
         int sumTwo = 0;
         for (int value : arr1) {
             sumOne ^= value;
         }
         for (int value : arr2) {
             sumTwo ^= value;
         }
        return (sumOne & sumTwo);
    }
}
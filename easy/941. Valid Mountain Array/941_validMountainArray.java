//I used a two-pointer approach. Starting from the beginning of the array, 
//I incremented i while A[i] is less than A[i + 1], simulating the ascent of the mountain. 
//If i reaches the end or the peak is at the start (i == 0) or end (i == N - 1), 
//I conclude it's not a valid mountain. 
//Then, I continued iterating while A[i] is greater than A[i + 1], simulating the descent. 
//Finally, if i reaches the end of the array (i == N - 1), it confirms A is a valid mountain array.
//Time: n
//Space: constant
class Solution {
    public boolean 
    (int[] A) {
        int N = A.length;
        int i = 0;

        // walk up
        while (i + 1 < N && A[i] < A[i + 1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N - 1)
            return false;

        // walk down
        while (i + 1 < N && A[i] > A[i + 1])
            i++;

        return i == N - 1;
    }
}
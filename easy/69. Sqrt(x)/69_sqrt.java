//To solve this question, we can use a binary search approach. 
//If the number is 1, then just return 1. Else, we know that the answer is going to be smaller than x/2 and > 0.
//So, we do binary search from 2 to x/2, and select the middle value, take the square of that, check if its smaller or greater than x.
//If greater, then select the left half, if smaller, then select the right half.
//Continue until found or left <= right.

//Time: O(logn)
//Space: O(1)

class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long num;
        int pivot;
        int left = 2; //left boundary
        int right = x / 2; //right boundary
        while (left <= right) {
            pivot = left + (right - left) / 2; //middle value
            num = (long) pivot * pivot; //square of middle value
            if (num > x) //if square is greater, then select the left half and redo
                right = pivot - 1;
            else if (num < x) //if square is smaller, then select the right half
                left = pivot + 1;
            else //found
                return pivot;
        }
        return right;
    }
}
//I approached the problem of computing an array where each element is the product of all elements 
//in the input array except itself using two passes through the array. In the first pass (left pass),
//I computed products of all elements to the left of each element using a prefix product approach. 
//Starting with answer[0] initialized to 1, each subsequent answer[i] was derived from nums[i-1] 
//and answer[i-1].
//In the second pass (right pass), I computed the products of all elements to the right of each 
//element using a suffix product approach. Initializing R to 1, I updated each answer[i] by 
//multiplying it with R and then updated R by multiplying it with nums[i].

//Time: n
//Space: constant
/*
nums = 1, 2, 3, 4
answer = 0, 0, 0, 0
left pass
1, 0, 0, 0
1, 1, 0, 0
1, 1, 2, 6
right pass
1, 1, 8, 6
1, 12, 8, 6
24, 12, 8, 6 -> return
*/
class Solution {

    public int[] productExceptSelf(int[] nums) {
        // The length of the input array
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the
        // right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // For the index 'i', R would contain the
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }
}
//I used two bitwise tricks to find the two unique numbers in the array efficiently. 
//First, I built a bitmask by XORing all elements, leaving only the bits that appear an odd 
//number of times. Then, I isolated the rightmost 1-bit difference between the unique 
//numbers using x & (-x). This helped me separate the numbers into two groups based on whether 
//they have this bit set or not. Finally, I used XOR operations to find each unique 
//number individually. 

//Time: O(n)
//Space: O(1)
class Solution {
    public int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums)
            bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums)
            if ((num & diff) != 0)
                x ^= num;

        return new int[] { x, bitmask ^ x };
    }
}
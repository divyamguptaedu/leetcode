//In this approach, I counted the number of wonderful substrings by maintaining a 
//count of each state using an array. The state represents the parity of each letter 
//in the substring. I initialized the count of an empty string as 1, 
//indicating all characters occur even times. Then, I iterated through the characters 
//of the word, updating the state and calculating the count of wonderful substrings. 
//By XORing the current state with each possible odd occurrence, 
//I accounted for substrings with exactly one letter appearing an odd number of times. 

//Time: O(n)
//Space: O(1)
class Solution {
    public long wonderfulSubstrings(String word) {
        long[] cnt = new long[1024]; // cnt[state] stores how many times the state occurs
        cnt[0] = 1; // empty string gives case where all characters occur even number of times
        int mask = 0; // current state
        long ans = 0;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int idx = c - 'a';
            mask ^= 1 << idx; // update state
            ans += cnt[mask]; // add count of same previous states
            for (int i = 1; i <= 512; i *= 2) {
                ans += cnt[mask ^ i];
            }
            cnt[mask]++; // add 1 to count of times we've seen current state
        }
        return ans;
    }
}
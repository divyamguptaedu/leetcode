//I solved the problem by using a set to track characters with odd occurrences. 
//I iterated through each character in the string s. 
//If the character was not in the set, I added it; if it was already in the set, I removed it. 
//By the end of the iteration, the set contained only the characters with odd frequencies. 
//For a string to be able to form a palindrome, it can have at most one character with an 
//odd frequency. Therefore, I returned true if the size of the set was less than or equal to one, 
//indicating that a palindrome permutation is possible.

//Time: O(n)
//Space: O(1)
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }
}

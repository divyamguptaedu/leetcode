//We can solve this question using a sliding window approach in which we just have to iterate over the string once.
//What we can do is that we set to pointers, i and j, to 0. We keep on moving j further and adding each char to the map with its index number until a duplicate is found.
//Once a duplicate is found, we move the i pointer to the original index + 1 of that char, shortenning the window.
//And then we continue extending the j as before.
//In the whole process, we keep track of the maximum length seen till now and return that in the end.

//Time: O(n) // n is the length of the string s
//Space: O(min(n, m)) //in the worst case, the size of the map can be m which is max char in alphabet for s.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1); //for i to be set to the char one ahead of this char
        }
        return ans;
    }
}
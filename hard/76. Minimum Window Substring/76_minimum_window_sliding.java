//We would first check if the length of either of s and t is zero, in that case we just return an empty string.
//Then we create a dictionary out of t to understand what all we need in what quantity.
//Then we check the size of that dictionary to understand how many matches are formed. A match is formed when the substring of s has 
//a char in a quantity <= what is required.
//We then filter all the chars from s into a new list along with their index, filter them by what we care about, i.e. letters in t.
//Then we start the sliding window on the new list, check if connection is formed, try and cut the substring from the left to find the shortest.
//Then save the length, start, and end index of that substring. 
//And move the right pointer to find more possibilities.

//Time: O(S+T) where S is the length of string s and T is the length of string t
//Space: O(S+T)
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> dictT = new HashMap<Character, Integer>(); //dictionary for t
        for (int i = 0; i < t.length(); i++) { //prepare the dictionary for t
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }
        int required = dictT.size(); //required matches

        // Filter all the characters from s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                filteredS.add(new Pair<Integer, Character>(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = { -1, 0, 0 };

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while (r < filteredS.size()) {
            char c = filteredS.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) { //check if connection formed
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = filteredS.get(l).getValue();

                // Save the smallest window until now.
                int end = filteredS.get(r).getKey();
                int start = filteredS.get(l).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) { //either first or smaller substring than before
                    ans[0] = end - start + 1; //length of the current substring
                    ans[1] = start;
                    ans[2] = end;
                }

                windowCounts.put(c, windowCounts.get(c) - 1); //chopping off the leftmost char
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) { //if match un-formed
                    formed--;
                }
                l++; //move forward
            }
            r++; //move forward to find a match
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
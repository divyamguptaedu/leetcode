//I used a HashMap to count occurrences of each character. First, I iterated through the string to populate the HashMap with character counts. 
//Then, I traversed the string again to find the first character with a count of 1 in the HashMap, indicating it is unique. 
//Upon finding such a character, I returned its index. If no unique character was found, I returned -1.
//TC: N
//SC: constant
class Solution {
    public int 
    (String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
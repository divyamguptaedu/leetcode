//To solve the problem of determining if a pattern and a string follow the same bijection, 
//I used a HashMap to map each character in the pattern to its index and the corresponding word to its
//index as well. I split the string s into words and checked if each character in pattern mapped 
//consistently to the same index as its corresponding word in words. If any inconsistency was found 
//during mapping, the function returned false.

//Time: m+n where m is the len of pattern and n is the len of s.
//Space: n (len of s)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap map_index = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (!map_index.containsKey(c))
                map_index.put(c, i);

            if (!map_index.containsKey(w))
                map_index.put(w, i);

            if (map_index.get(c) != map_index.get(w))
                return false;
        }

        return true;
    }
}
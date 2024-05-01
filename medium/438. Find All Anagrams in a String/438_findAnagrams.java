//To solve this question, the first thing we will do is check the length of s and p, if s is shorter than p, then just return empty list.
//Next, we would build the frequency map for p which we can use to check if a window in s is an anagram of p or not.
//To make it easier, we can use an int array of 26 to compare in O(26) time.
//Next, we would iterate on the s string with a window size of length of p and populate the map for s. 
//When we add an element to the window on the right, we remove the left most as well (only when we have a window of size p ready), and we edit the map accordingly.
//For comparison, we just compare if the two arrays are equal.

//Time: O(n)
//Space: O(26)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int ns = s.length();
        int np = p.length();
        if (ns < np) {
            return new ArrayList();
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // build reference array using string p
        for (char ch : p.toCharArray()) {
            pCount[(int)(ch - 'a')]++;
        }

        List<Integer> output = new ArrayList();
        // sliding window on the string s
        for (int i = 0; i < ns; i++) {
            // add one more letter 
            // on the right side of the window
            sCount[(int)(s.charAt(i) - 'a')]++;
            // remove one letter 
            // from the left side of the window
            if (i >= np) {
                sCount[(int)(s.charAt(i - np) - 'a')]--;
            }
            // compare array in the sliding window
            // with the reference array
            if (Arrays.equals(pCount, sCount)) {
                output.add(i - np + 1);
            }
        }
        return output;
    }
}
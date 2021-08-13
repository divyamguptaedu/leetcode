"""
Performance:
Runtime: 1649 ms, faster than 6.99% of Java online submissions for Find All Anagrams in a String.
Memory Usage: 40.3 MB, less than 26.69% of Java online submissions for Find All Anagrams in a String.
"""

class Solution {
	public List<Integer> findAnagrams(String s, String p) {


        // form a character array;
        List<Integer> list = new ArrayList<>();
        char temp[] = p.toCharArray();

        // sort it;
        Arrays.sort(temp);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
        	String w = s.substring(i, i + p.length());
          // form a temp array and sort it;
         	char tempTwo[] = w.toCharArray();
          	Arrays.sort(tempTwo);
            // compare;
          	if (Arrays.equals(temp,tempTwo)) {
            	list.add(i);
          	}
        }
        return list;
	}
}
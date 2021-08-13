"""
Performance:
"""

class Solution {
	public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        char temp[] = p.toCharArray();
        Arrays.sort(temp);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
        	String w = s.substring(i, i + p.length());
         	char tempTwo[] = w.toCharArray();
          	Arrays.sort(tempTwo);
          	if (Arrays.equals(temp,tempTwo)) {
            	list.add(i);
          	}
        }
        return list;
	}
}
"""
Performance:
Runtime: 6 ms, faster than 78.02% of Java online submissions for Group Anagrams.
Memory Usage: 42.1 MB, less than 68.14% of Java online submissions for Group Anagrams.
"""

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> result = new ArrayList<>();
    	HashMap<String, List<String>> hashmap = new HashMap<>();
        char[] charArray;
        List<String> tempList;
        String temp;
        for (String s : strs) {
        	charArray = s.toCharArray();
        	Arrays.sort(charArray);
        	temp = new String(charArray);
        	if (hashmap.get(temp) == null) {
        		tempList = new ArrayList<String>();
        		tempList.add(s);
        		hashmap.put(temp, tempList);
        	} else {
        		tempList = hashmap.get(temp);
        		tempList.add(s);
        		hashmap.put(temp, tempList);
        	}
        }
        for (List<String> x : hashmap.values()) {
        	result.add(x);
        }
        return result;
    }
}
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
            
            // convert each string to char array and sort.
        	charArray = s.toCharArray();
        	Arrays.sort(charArray);
        	temp = new String(charArray);

            // add the sorted char array string to the hashmap.
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

        // return values;
        for (List<String> x : hashmap.values()) {
        	result.add(x);
        }
        return result;
    }
}

"cleaner version"

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hm = new HashMap<>();
        for (String s : strs) {
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}
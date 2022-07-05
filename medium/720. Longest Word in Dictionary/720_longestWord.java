class Solution {
    public String longestWord(String[] words) {
        Set<String> hashSet = new HashSet<>();
        for (String word : words) {
            hashSet.add(word);
        }
        String result = "";
        int length = 0;
        
        for (String temp : hashSet) {
            boolean found = true;
            for (int i = 1; i < temp.length(); i++) {
                String substring = temp.substring(0, i);
                if (!hashSet.contains(substring)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                if (temp.length() > length) {
                    result = temp.size();
                }
                else if(temp.length() == length && temp.compareTo(result) < 0){
                    length = temp.size();
                    result = temp;
                }
            }
        }
        
        return result;
    }
}
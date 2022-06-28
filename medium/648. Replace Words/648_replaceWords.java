"
Performance:
Runtime: 47 ms, faster than 35.84% of Java online submissions for Replace Words.
Memory Usage: 53.7 MB, less than 88.18% of Java online submissions for Replace Words.
"

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort((v1, v2) -> v1.length() - v2.length());
        String[] temp = sentence.split(" ");
        for (int i = 0; i < temp.length; i++) { 
            for (String root : dictionary) { 
                if (temp[i].startsWith(root)) {
                    temp[i] = root; 
                }
            }
        }
        return String.join(" ", temp); 
    }
}
//I processed each word in the sentence individually. 
//For words starting with a vowel, I appended "ma" and added 'a's based on their index. 
//For words starting with a consonant, I moved the first letter to the end, added "ma", 
//and appended 'a's. I handled both lowercase and uppercase vowels. 
//Throughout the process, I utilized a StringBuilder for efficient string manipulation 
//and joined the words with spaces for the final output.

//Time: O(nm) where n is the #words in the sentence and m is the avg len of words.
//Space: O(nm)
class Solution {
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            if (str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o'
                    || str.charAt(0) == 'u' || str.charAt(0) == 'A' || str.charAt(0) == 'E' || str.charAt(0) == 'I'
                    || str.charAt(0) == 'O' || str.charAt(0) == 'U') {
                sb.append(str);
                sb.append("ma");
                for (int j = 0; j <= i; j++) {
                    sb.append('a');
                }
                sb.append(' ');
            } else {
                char ch = str.charAt(0);
                String strr = str.substring(1, str.length());
                sb.append(strr);
                sb.append(ch);
                sb.append("ma");
                for (int j = 0; j <= i; j++) {
                    sb.append('a');
                }
                sb.append(' ');
            }
        }
        return sb.toString().trim();
    }
}
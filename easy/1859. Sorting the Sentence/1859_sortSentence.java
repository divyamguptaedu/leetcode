//I approached the problem by first splitting the input string s into individual words using split(" "). 
//Each word in the resulting array str ends with a digit indicating its original position in the sentence. 
//I initialized a StringBuilder sb to construct the original sentence. 
//Iterating through str, I extracted each word's position using the last character, 
//converted it to an integer, and placed the word in its correct position in res. 
//Finally, I appended all words from res into sb to form the reconstructed sentence, ensuring proper spacing.

//Time: n
//Space: n
class Solution {
    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] rearranged = new String[words.length];
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '0' - 1;
            rearranged[index] = word.substring(0, word.length() - 1);
        }
        
        for (int i = 0; i < rearranged.length - 1; i++) {
            sb.append(rearranged[i]).append(" ");
        }
        sb.append(rearranged[rearranged.length - 1]);
        
        return sb.toString();
    }
}

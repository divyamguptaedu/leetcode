//In solving the problem of reversing words in a string, 
//I first eliminated leading and trailing spaces from the input string s. 
//This was done using two while loops, adjusting indices left and right until no more 
//leading or trailing spaces were encountered.
//Next, I utilized a Deque (double-ended queue) to store each word extracted from 
//the trimmed string. As I traversed the string from left to right, 
//I built each word character by character into a StringBuilder. 
//Upon encountering a space or reaching the end of a word, 
//I pushed the completed word onto the front of the Deque.
//Finally, I joined all words from the Deque into a single string separated by a single space 
//and returned the result.

//Time: n
//Space: n
class Solution {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // remove leading spaces
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // remove trailing spaces
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque();
        StringBuilder word = new StringBuilder();
        // push word by word in front of deque
        while (left <= right) {
            char c = s.charAt(left);

            if ((word.length() != 0) && (c == ' ')) {
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
}
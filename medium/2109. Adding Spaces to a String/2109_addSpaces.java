//I processed the string s and an array spaces containing indices where spaces should be inserted. 
//Using two pointers (i for iterating through s and j for iterating through spaces), 
//I constructed a new character array res to accommodate the original string and additional spaces. 
//As I iterated through s, whenever i matched an index in spaces, I inserted a space into res. 
//After processing all indices in spaces, I appended any remaining characters from s to res. 
//Finally, I converted res back to a string and returned it as the modified string with added spaces.
//Time: m+n where m is the len of string s and n is the num of elements in spaces.
//Space: m+n
class Solution {
    public String addSpaces(String s, int[] spaces) {
        int m = s.length(); // length of the original string
        int n = spaces.length; // number of spaces to insert
        int i = 0, j = 0, k = 0; // pointers for iterating through s, spaces, and res
        char[] result = new char[m + n]; // array to store result string

        // Iterate through s and spaces to construct result
        while (i < m && j < n) {
            int currSpace = spaces[j];
            // Copy characters from s to result until we reach the current space index
            while (i < m && i < currSpace) {
                result[k++] = s.charAt(i++);
            }
            // Insert a space into result at the current space index
            result[k++] = ' ';
            j++; // move to the next space index
        }

        // Append remaining characters from s to result
        while (i < m) {
            result[k++] = s.charAt(i++);
        }

        return new String(result); // convert char array to string and return
    }
}

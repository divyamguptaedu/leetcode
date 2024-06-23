//I employed a iterative approach using a StringBuilder. 
//Starting from the integer, I decremented it by 1 to handle the 1-based indexing in Excel columns. 
//Using modulo operation (columnNumber % 26), I derived the character corresponding to the least significant digit of the column title. 
//This character was then appended to the StringBuilder after converting it to the corresponding character ('A' + remainder). 
//I then updated columnNumber by integer division (columnNumber / 26) to process the next digit. 
//Finally, I reversed the StringBuilder to obtain the correct order of characters.

//TC: logn
//SC: constant
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            // Get the last character and append it at the end of the string.
            ans.append((char) (((columnNumber) % 26) + 'A'));
            columnNumber = (columnNumber) / 26;
        }

        // Reverse it, as we appended characters in reverse order.
        return ans.reverse().toString();
    }
}
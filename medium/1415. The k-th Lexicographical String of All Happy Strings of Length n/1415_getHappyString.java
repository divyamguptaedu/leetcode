//I generated all possible happy strings of length n using backtracking. 
//I defined a helper method to recursively build each string, ensuring no two consecutive characters are the same. 
//Starting with an empty string, I appended each character ('a', 'b', 'c') 
//if it didn't match the last character of the current string. Once a string reached length n, 
//I added it to the list of results. 
//I returned the k-th string from this list if it existed, or an empty string otherwise.
//Time: 3^n
//Space: n
class Solution {
    public String getHappyString(int length, int position) {
        List<String> happyStrings = new ArrayList<>();
        char[] allowedChars = new char[] { 'a', 'b', 'c' };
        generateHappyStrings(length, position, happyStrings, allowedChars, new StringBuilder());
        return happyStrings.size() < position ? "" : happyStrings.get(position - 1);
    }

    private void generateHappyStrings(int length, int position, List<String> happyStrings, char[] allowedChars, StringBuilder currentString) {
        // If we have enough happy strings, stop the process
        if (happyStrings.size() >= position) {
            return;
        }
        // If the current string has reached the required length, add it to the list
        if (currentString.length() == length) {
            happyStrings.add(currentString.toString());
            return;
        }
        // Try to append each allowed character
        for (int i = 0; i < allowedChars.length; i++) {
            // Skip if the last character of the current string is the same as the current character
            if (currentString.length() > 0 && currentString.charAt(currentString.length() - 1) == allowedChars[i]) {
                continue;
            }
            // Append the character and continue the backtracking process
            currentString.append(allowedChars[i]);
            generateHappyStrings(length, position, happyStrings, allowedChars, currentString);
            // If we have enough happy strings, stop the process
            if (happyStrings.size() >= position) {
                return;
            }
            // Remove the last character to try the next possibility
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
}
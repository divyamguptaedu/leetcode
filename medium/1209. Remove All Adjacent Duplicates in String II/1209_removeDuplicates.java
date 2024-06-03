//We can either use a stack approach or a two pointer approach.
//Stack Approach:
//I maintain a stack to keep track of characters and their respective counts. 
//I iterate through the string, pushing characters onto the stack and incrementing 
//their count if they are the same as the top character of the stack. 
//If the count reaches 'k', I pop the character from the stack. 
//Finally, I construct the resultant string by popping characters from the stack and 
//appending them to a StringBuilder. Since we reverse the order when constructing the string, 
//the removals from the end of the original string correspond to the top of the stack.

//Time: O(n)
//Space: O(n)
class Pair {
    int cnt; // Stores the count of adjacent characters
    char ch; // Stores the character itself

    // Constructor to initialize the Pair with count and character
    public Pair(int cnt, char ch) {
        this.ch = ch;
        this.cnt = cnt;
    }
}

class Solution {
    // Function to remove duplicates with a constraint of 'k'
    public String removeDuplicates(String s, int k) {
        Stack<Pair> counts = new Stack<>(); // Stack to store counts of adjacent characters
        // Iterate through each character in the string
        for (int i = 0; i < s.length(); ++i) {
            // If the stack is empty or the current character is different from the top of the stack
            if (counts.empty() || s.charAt(i) != counts.peek().ch) {
                counts.push(new Pair(1, s.charAt(i))); // Push a new Pair onto the stack with count 1
            } else {
                // If the current character is the same as the top of the stack
                if (++counts.peek().cnt == k) { // Increment the count of the top Pair
                    counts.pop(); // If count reaches 'k', pop it from the stack
                }
            }
        }
        StringBuilder b = new StringBuilder(); // StringBuilder to store the resultant string
        // Iterate through the remaining Pairs in the stack
        while (!counts.empty()) {
            Pair p = counts.pop(); // Pop the top Pair
            // Append the character 'cnt' times to the StringBuilder
            for (int i = 0; i < p.cnt; i++) {
                b.append(p.ch);
            }
        }
        // Return the reversed StringBuilder as the final result
        return b.reverse().toString();
    }
}

// Two Pointer Approach:
// I iterate through the string 's' while maintaining a stack 'counts' to keep track of
// the consecutive counts of characters. If the current character is different from the
// previous one or it's the first character, I push '1' onto the stack.
// Otherwise, I increment the count of the top of the stack and check if it reaches 'k'.
// If so, I backtrack 'k' positions in the array 'sa', effectively removing the k adjacent duplicates.
// Finally, I construct and return the resultant string from the modified character array.

class Solution {
    public String removeDuplicates(String s, int k) {
        // Stack to store the counts of adjacent characters
        Stack<Integer> counts = new Stack<>();
        // Convert the string to a character array for in-place modification
        char[] sa = s.toCharArray();
        int j = 0; // Pointer for the modified character array
        // Iterate through the original string
        for (int i = 0; i < s.length(); ++i, ++j) {
            sa[j] = sa[i]; // Copy the character to the modified array
            // If it's the first character or different from the previous one
            if (j == 0 || sa[j] != sa[j - 1]) {
                counts.push(1); // Push 1 onto the counts stack
            } else {
                int incremented = counts.pop() + 1; // Increment the count of the top of the stack
                // If the count reaches 'k', backtrack 'k' positions
                if (incremented == k) {
                    j = j - k;
                } else {
                    counts.push(incremented); // Otherwise, push the incremented count onto the stack
                }
            }
        }
        // Construct and return the resultant string from the modified character array
        return new String(sa, 0, j);
    }
}
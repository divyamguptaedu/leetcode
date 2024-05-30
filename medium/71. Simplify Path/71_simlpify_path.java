//I parsed the input path by splitting it with "/" as the delimiter. 
//Then, I iterated through each component, handling ".", "..", and valid directory names accordingly. 
//For ".", I continued; for "..", I popped from the stack if it's non-empty; for valid directory names, 
//I added them to the stack. After processing, I reconstructed the simplified canonical path from the stack elements, 
//ensuring proper separation with a single "/". 
//If the resulting path is empty, I returned "/" indicating the root directory. 
//Otherwise, I returned the constructed path.

//Time: O(n)
//Space: O(n)
class Solution {
    public String simplifyPath(String path) {
        // Initialize a stack
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");

        // Split the input string on "/" as the delimiter
        // and process each portion one by one
        for (String directory : components) {
            // A no-op for a "." or an empty string
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                // If the current component is a "..", then
                // we pop an entry from the stack if it's non-empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Finally, a legitimate directory name, so we add it
                // to our stack
                stack.add(directory);
            }
        }

        // Stich together all the directory names together
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}
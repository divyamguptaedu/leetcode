//Utilized a hashmap to store mappings of open and close parentheses.
//It employs a stack to validate the string. For each character in the input string, it checks if it's an open parenthesis; 
//if so, it pushes it onto the stack. If it's a closing parenthesis, it verifies whether the corresponding open parenthesis 
//matches the one at the top of the stack. If not, or if the stack is empty, it returns false. 
//If the stack is empty after processing the entire string, it returns true; otherwise, false is returned. 

//Time: O(n)
//Space: O(n)
class Solution {
    public boolean isValid(String s) {
        // Create hashmap to store the pairs...
        HashMap<Character, Character> Hmap = new HashMap<Character, Character>();
        Hmap.put(')','(');
        Hmap.put('}','{');
        Hmap.put(']','[');
        // Create stack data structure...
        Stack<Character> stack = new Stack<Character>();
        // Traverse each charater in input string...
        for (int idx = 0; idx < s.length(); idx++){
            // If open parentheses are present, push it to stack...
            if (s.charAt(idx) == '(' || s.charAt(idx) == '{' || s.charAt(idx) == '[') {
                stack.push(s.charAt(idx));
                continue;
            }
            // If the character is closing parentheses, check that the same type opening parentheses is being pushed to the stack or not...
            // If not, we need to return false...
            if (stack.size() == 0 || Hmap.get(s.charAt(idx)) != stack.pop()) {
                return false;
            }
        }
        // If the stack is empty, return true...
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
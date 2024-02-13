class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
        
    }
}

//another solution

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else if (stack.empty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.empty();    
    }
}
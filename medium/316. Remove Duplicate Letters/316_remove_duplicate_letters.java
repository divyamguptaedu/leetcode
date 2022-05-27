/*
Runtime: 2 ms, faster than 98.40% of Java online submissions for Remove Duplicate Letters.
Memory Usage: 40.9 MB, less than 96.03% of Java online submissions for Remove Duplicate Letters.
*/

class Solution {
    public String removeDuplicateLetters(String s) {
        int array[] = new int[26];
        boolean boolArray[] = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {                        
            array[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            array[temp-'a']--;
            if (boolArray[temp - 'a']) {
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > temp && array[stack.peek() - 'a'] > 0) {
                char tempTwo = stack.pop();
                boolArray[tempTwo-'a'] = false;                    
            }
                stack.push(temp);
                boolArray[temp - 'a'] = true;    
        }        
        char answer[] = new char[stack.size()];
        int i = answer.length - 1;
        while (i >= 0) {            
            answer[i--] = stack.pop();            
        }
        return new String(answer);
    }
}
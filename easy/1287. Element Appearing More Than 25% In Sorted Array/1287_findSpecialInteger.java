class Solution {
  public String removeDuplicates(String S) {
      
    HashSet<String> duplicates = new HashSet();
    StringBuilder duplicate = new StringBuilder();
    for (char i = 'a'; i <= 'z'; ++i) {
        duplicate.setLength(0);
        duplicate.append(i);
        duplicate.append(i);
        duplicates.add(duplicate.toString());
    }

    int prevLength = -1;
    while (prevLength != S.length()) {
      prevLength = S.length();
      for (String d : duplicates) {
          S = S.replace(d, "");
      }
    }

    return S;
  }
}

//another solution

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder("");
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
}
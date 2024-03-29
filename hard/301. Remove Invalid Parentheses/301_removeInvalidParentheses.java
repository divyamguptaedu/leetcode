public class Solution {
    public List<String> removeInvalidParentheses(String s) {
      List<String> result = new ArrayList<>();
      if (s == null) {
          return result;
      }
      Set<String> visited = new HashSet<>();
      Queue<String> queue = new LinkedList<>();
      queue.add(s);
      visited.add(s);
      boolean found = false;

      while (!queue.isEmpty()) {
        s = queue.poll();
        if (isValid(s)) {
          result.add(s);
          found = true;
        }
        if (found) {
            continue;
        }
        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) != '(' && s.charAt(i) != ')') {
              continue;
          }
          String temp = s.substring(0, i) + s.substring(i + 1);
          if (!visited.contains(temp)) {
            queue.add(temp);
            visited.add(temp);
          }
        }
      }
      
      return result;
    }

    boolean isValid(String s) {
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') {
            count++;
        }
        if (c == ')' && count-- == 0) {
            return false;
        }
      }
      return count == 0;
    }
}
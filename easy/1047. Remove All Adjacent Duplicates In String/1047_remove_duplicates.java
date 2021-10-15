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
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
       List<String> result = new ArrayList<>();
       int index = 0;
       while (index < words.length) {
           int size = words[index].length();
           int next = index + 1;
           while (next < words.length) {
               if (words[next].length() + size + 1 > maxWidth) {
                   break;
               }
               size += words[next].length() + 1;
               next++;
           }
           StringBuilder sb = new StringBuilder();
           int difference = next - index - 1;
           if (next == words.length || difference == 0) {
               for (int i = index; i < next; i++) {
                   sb.append(words[i] + " ");
               }
               sb.deleteCharAt(sb.length() - 1);
               for (int i = sb.length(); i < maxWidth; i++) {
                   sb.append(" ");
               }
           } else {
               int gaps = (maxWidth - size) / difference;
               int remainingGaps = (maxWidth - size) % difference;
               for (int i = index; i < next; i++) {
                   sb.append(words[i]);
                   if (i < next - 1) {
                       for (int j = 0; j <= (gaps + ((i - index) < remainingGaps ? 1 : 0)); j++) {
                           sb.append(" ");
                       }
                   }
               }
           }
            result.add(sb.toString());
            index = next;
        }
        return result;
    }
}

















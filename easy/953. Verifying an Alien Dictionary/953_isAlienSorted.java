class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!check(words[i], words[i+1], map)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(String firstString, String secondString, HashMap<Character, Integer> map)
    {
        for (int i = 0; i < Math.min(firstString.length(), secondString.length()); i++) {
           if (firstString.charAt(i) != secondString.charAt(i)) {
                return map.get(firstString.charAt(i)) < map.get(secondString.charAt(i));
           }
        }
        return firstString.length() <= secondString.length();
    }
}
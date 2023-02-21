class Solution {
    HashMap<Character, Integer> charToIntMap = new HashMap<>();
    boolean[] usedNumbers = new boolean[10];
    String uniqueCharacters = "";
    int total = 0;
    int resultNumber = 0;
    public boolean isSolvable(String[] words, String result) {
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                if (!charToIntMap.containsKey(s.charAt(i))) {
                    charToIntMap.put(s.charAt(i), -1);
                    uniqueCharacters += s.charAt(i);
                }
            }
        }
        for (int i = 0; i < result.length(); i++) {
                if (!charToIntMap.containsKey(result.charAt(i))) {
                    charToIntMap.put(result.charAt(i), -1);
                    uniqueCharacters += result.charAt(i);
                }
        }
        return assignNumbers(uniqueCharacters, 0, charToIntMap, usedNumbers, words, result);
    }

    private boolean assignNumbers(String uniqueCharacters, int index, HashMap<Character, Integer> charToIntMap, boolean[] usedNumbers, String[] words, String result) {
        if (index == uniqueCharacters.length()) {
            total = 0;
            for (String s : words) {
                total += getNumber(s, charToIntMap);
            }
            resultNumber = getNumber(result, charToIntMap);
            if (total == resultNumber) {
                return true;
            }
            return false;
        }
        
        char ch = uniqueCharacters.charAt(index);
        for (int number = 0; number <= 9; number++) {
            if (usedNumbers[number] == false) {
                charToIntMap.put(ch, number);
                usedNumbers[number] = true;
                if (assignNumbers(uniqueCharacters, index + 1, charToIntMap, usedNumbers, words, result)) {
                    return true;
                }
                usedNumbers[number] = false;
                charToIntMap.put(ch, -1);
            }
        }
        return false;
    }

    private int getNumber(String s, HashMap<Character, Integer> charToIntMap) {
        String number = "";
        for (int i = 0; i < s.length(); i++) {
            number += charToIntMap.get(s.charAt(i));
        }
        return Integer.parseInt(number);
    }
}
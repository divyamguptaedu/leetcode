//I defined a Deterministic Finite Automaton (DFA) to validate numbers based on the given rules. 
//The DFA transitions between states based on the current character's type (digit, sign, exponent, or dot). 
//If the DFA encounters an invalid character or reaches a state with no transition for the next character, 
//it returns false. After processing all characters, if the DFA is in a valid final state, 
//the number is considered valid.

//Time: O(n) where n is the length of string s
//Space: O(1)
class Solution {
    // This is the DFA we have designed above
    private static final List<Map<String, Integer>> dfa = List.of(
            Map.of("digit", 1, "sign", 2, "dot", 3),
            Map.of("digit", 1, "dot", 4, "exponent", 5),
            Map.of("digit", 1, "dot", 3),
            Map.of("digit", 4),
            Map.of("digit", 4, "exponent", 5),
            Map.of("sign", 6, "digit", 7),
            Map.of("digit", 7),
            Map.of("digit", 7));

    // These are all of the valid finishing states for our DFA.
    private static final Set<Integer> validFinalStates = Set.of(1, 4, 7);

    public boolean isNumber(String s) {
        int currentState = 0;
        String group = "";

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                group = "digit";
            } else if (curr == '+' || curr == '-') {
                group = "sign";
            } else if (curr == 'e' || curr == 'E') {
                group = "exponent";
            } else if (curr == '.') {
                group = "dot";
            } else {
                return false;
            }

            if (!dfa.get(currentState).containsKey(group)) {
                return false;
            }

            currentState = dfa.get(currentState).get(group);
        }

        return validFinalStates.contains(currentState);
    }
}
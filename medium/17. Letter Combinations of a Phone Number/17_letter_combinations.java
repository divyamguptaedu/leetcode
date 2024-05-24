//Backtracking solution
//I mapped each digit to its corresponding letters using a hash map. 
//I wrote a recursive function to generate combinations, starting with an empty path and the first digit. 
//For each digit, I looped through its possible letters, adding each letter to the path and calling the function recursively 
//for the next digit. If the current path length matched the input length, I added the path to the result. 
//After exploring each letter, I removed it from the path to backtrack and try the next letter.

//Time: O(N * 4^N) where N is the length of digits. 4 refers to the max value length in hashmap, not the length of input. 
//In worst case the input just has 7s and 9s, we have to explore 4 additional paths for every extra digit.
//Space: O(N)
class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String phoneDigits;

    public List<String> letterCombinations(String digits) {
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return combinations;
        }

        // Initiate backtracking with an empty path and starting index of 0
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int index, StringBuilder path) {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter : possibleLetters.toCharArray()) {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }
}
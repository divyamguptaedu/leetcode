//For each line, I calculated the extra spaces needed and distributed them
//as evenly as possible between the words. 
//If the spaces could not be evenly distributed, I added more spaces to the left slots.
//The last line was treated separately to ensure it was left-justified.
//This ensured that each line was properly justified according to the rules.

//Time: nk where n is the #words and k is the avg len of a word
//Space: m
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        // Process each line
        while (index < words.length) {
            // Get the words for the current line
            List<String> currentLine = getWordsForLine(index, words, maxWidth);
            index += currentLine.size();
            // Create the justified line and add it to the result
            result.add(createJustifiedLine(currentLine, index, words, maxWidth));
        }
        return result;
    }

    private List<String> getWordsForLine(int startIndex, String[] words, int maxWidth) {
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        // Add words to the current line until maxWidth is exceeded
        while (startIndex < words.length && currentLength + words[startIndex].length() <= maxWidth) {
            currentLine.add(words[startIndex]);
            currentLength += words[startIndex].length() + 1; // Adding 1 for the space
            startIndex++;
        }
        return currentLine;
    }

    private String createJustifiedLine(List<String> line, int nextIndex, String[] words, int maxWidth) {
        int baseLength = -1;
        // Calculate the base length of the line (sum of word lengths plus spaces)
        for (String word : line) {
            baseLength += word.length() + 1; // Adding 1 for the space
        }
        int extraSpaces = maxWidth - baseLength;

        // Handle the case for the last line or lines with one word
        if (line.size() == 1 || nextIndex == words.length) {
            // Join the words with a single space and add remaining spaces at the end
            return String.join(" ", line) + " ".repeat(extraSpaces);
        }

        int spacesPerSlot = extraSpaces / (line.size() - 1); // Minimum spaces to add between words
        int extraSlots = extraSpaces % (line.size() - 1);    // Extra spaces to distribute

        // Distribute extra spaces among the words
        for (int j = 0; j < extraSlots; j++) {
            line.set(j, line.get(j) + " "); // Add one extra space to the leftmost slots
        }
        for (int j = 0; j < line.size() - 1; j++) {
            line.set(j, line.get(j) + " ".repeat(spacesPerSlot)); // Add the calculated spaces
        }
        return String.join(" ", line); // Join the words with spaces and return the justified line
    }
}
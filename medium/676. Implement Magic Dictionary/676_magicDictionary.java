//We can use just a string array to initialize the dictionary. When it comes to search, we will take every string in the data,
//and check if there's only one char difference or not. To check that, first we will compare the length of the word from the data and the search word.
//Then we will just iteratively check if there's more than one char difference. If yes, we break.

//Time: O(mn) Search would take O(mn) where m is the length of the word and n is the number of words.
//Space: O(n)
class MagicDictionary {
    private String[] data;

    public void buildDict(String[] dictionary) {
        this.data = dictionary;
    }

    public boolean search(String searchWord) {
        for (String element : data) {
            if (onlyOneCharDifferent(element, searchWord)) {
                return true;
            }
        }

        return false;
    }

    private boolean onlyOneCharDifferent(String element, String searchWord) {
        if (element.length() != searchWord.length()) {
            return false;
        }

        boolean onlyOneCharDifferent = false;

        for (int i = 0; i < element.length(); i++) {
            boolean differentChars = element.charAt(i) != searchWord.charAt(i);

            if (differentChars && !onlyOneCharDifferent) {
                onlyOneCharDifferent = true;
            } else if (differentChars) {
                onlyOneCharDifferent = false;
                break;
            }
        }

        return onlyOneCharDifferent;
    }
}
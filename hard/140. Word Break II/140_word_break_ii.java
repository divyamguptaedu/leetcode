//I used a top-down dynamic programming approach with memoization. 
//I stored the dictionary words in a set for quick look-up and used a hash map to memoize solutions for substrings of s. 
//For each substring, I checked all possible prefixes to see if they are in the dictionary. 
//If a prefix matched, I recursively solved the problem for the remaining substring and combined the results. 
//I stored each valid combination of words in the memo. 
//Finally, I concatenated the words in each solution to form valid sentences and returned the results.

//Time: O(N^2 + 2^N + W) where N is the length of string s, and W is the number of words in the dict
//Space: O(2^N * N  + W)
class Solution {
    protected Set<String> wordSet;
    protected HashMap<String, List<List<String>>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        memo = new HashMap<String, List<List<String>>>();

        helper(s);

        // chain up words together
        List<String> ret = new ArrayList<String>();
        for (List<String> words : memo.get(s)) {
            StringBuffer sentence = new StringBuffer();
            for (String word : words) {
                sentence.insert(0, word);
                sentence.insert(0, " ");
            }
            ret.add(sentence.toString().strip());
        }

        return ret;
    }

    private List<List<String>> helper(String s) {
        if (s.equals("")) {
            List<List<String>> solutions = new ArrayList<List<String>>();
            solutions.add(new ArrayList<String>());
            return solutions;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        } else {
            List<List<String>> solutions = new ArrayList<List<String>>();
            memo.put(s, solutions);
        }

        for (int endIndex = 1; endIndex <= s.length(); ++endIndex) {
            String word = s.substring(0, endIndex);
            if (wordSet.contains(word)) {
                List<List<String>> subsentences = helper(s.substring(endIndex));
                for (List<String> subsentence : subsentences) {
                    List<String> newSentence = new ArrayList<String>(
                        subsentence
                    );
                    newSentence.add(word);
                    memo.get(s).add(newSentence);
                }
            }
        }
        return memo.get(s);
    }
}
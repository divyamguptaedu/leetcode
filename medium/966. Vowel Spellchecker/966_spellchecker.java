class Solution {
    
    public Set<String> vowels = new HashSet<>(Arrays.asList("a","e","i","o","u"));

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> hashSet = new HashSet<>(Arrays.asList(wordlist));
        Map<String,String> hashMap = new HashMap<>();
        for (String letter : wordlist) {
            String last = letter.toLowerCase();
            String pattern = helper(letter);
            hashMap.putIfAbsent(last, letter);
            hashMap.putIfAbsent(pattern, letter);
        }
        for (int i = 0; i < queries.length; i++) {
            if (hashSet.contains(queries[i])) {
                continue;
            }
            String last = w.toLowerCase(), pattern = helper(w);
            if (hashMap.containsKey(last)) {
                queries[i] = hashMap.get(last); 
                continue;
            }
            if (hashMap.containsKey(pattern)) {
                queries[i] = hashMap.get(pattern); 
                continue;
            }
            queries[i] = "";
        }
        return queries;
    }
    
    private String helper(String s) {
        char[] array = s.toLowerCase().toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (vowels.contains(array[i])) {
                array[i] = '*';
            }
        }
        return new String(array);
    }
}
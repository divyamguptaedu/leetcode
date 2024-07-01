/*
Question description

Design a data structure to store a set of possibly nested placeholders organized by language. 
Using that data structure, write a function which given an input string with placeholders can return the expanded string, 
localized and falling back to English if a translation of the placeholder does not exist.


Definitions
set:
@param id       An id for a placeholder to live at
@param lang     The 2 character language code of the placeholder expansion
@param text     The text of the expanded placeholder

  

expand
@param string   String to expand any placeholders inside of
@param lang     Language to expand placeholders in

  

----------------- Notes ------------------
- Placeholders can contain other placeholders, expand should expand all placeholders if possible
- If a language is not available for a placeholder, that placeholder's English content (en) should be used

Examples
set('1234', 'en', 'Hello world')
set('1234', 'es', 'Hola mundo')

expand('{{dc.1234}}', 'en')

Hello world
  

expand('{{dc.1234}}', 'es')

Hola mundo
  

set('2345', 'en', '{{dc.1234}}, I'm alive!')

expand('{{dc.2345}}', 'en')

Hello world, I'm alive!
  

expand('{{dc.1234}}, fun times!', 'en')

Hello world, fun times!
  

expand('{{dc.2345}}', 'es')

Hola mundo, I'm alive!
*/

public class Placeholder {
    private Map<String, Map<String, String>> placeholders;

    public Placeholder() {
        this.placeholders = new HashMap<>();
    }

    public void set(String id, String lang, String text) {
        placeholders.putIfAbsent(id, new HashMap<>());
        placeholders.get(id).put(lang, text);
    }

    public String expand(String input, String lang) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        
        while (index < input.length()) {
            int startIndex = input.indexOf("{{dc.", index);
            if (startIndex == -1) {
                result.append(input.subString(index));
                break;
            }
            result.append(input.subString(index, startIndex));

            int endIndex = input.indexOf("}}", startIndex);
            if (endIndex == -1) {
                result.append(input.subString(startIndex));
                break;
            }
            
            String placeholderId = input.subString(startIndex + 5, endIndex);
            String replacement = getPlaceHolderText(placeholderId, lang); //helper method 1
            result.append(replacement);
            index = endIndex + 2;
        }

        String expanded = result.toString();

        while (containsPlaceholder(expanded)) {
            expanded = expand(expanded, lang);
        } //helper method 2

        return expanded;
    }

    private String getPlaceHolderText(String id, String lang) {
        if (placeholders.containsKey(id)) {
            Map<String, String> translations = placeholders.get(id);
            return translations.getOrDefault(lang, translations.get("en"));
        }
        return "";
    }

    private boolean containsPlaceholder(String input) {
        return input.contains("{{dc.");
    }
}
 

class ExpandPlaceholders {
    private Map<String, String> hashtable;

    public ExpandPlaceholders() {
        this.hashtable = new HashMap<>();
    }

    public void set(String id, String lang, String text) {
        String key = id + lang;
        hashtable.put(key, text);
    }

    public String expand(String string, String language) throws Exception {
        int i = 0;
        StringBuilder expandedString = new StringBuilder();

        // Iterate through the string to find placeholders
        while (i < string.length() - 7) {
            if (string.substring(i, i + 5).equals("{{dc.")) {
                i += 5;
                int startPlaceholder = i;
                while (string.charAt(i) != '}') {
                    i++;
                }
                String id = string.substring(startPlaceholder, i);

                // Check if the placeholder with the given language exists
                if (hashtable.containsKey(id + language)) {
                    expandedString.append(expand(hashtable.get(id + language), language));
                }
                // Fallback to 'en' if the specific language placeholder doesn't exist
                else if (hashtable.containsKey(id + "en")) {
                    expandedString.append(expand(hashtable.get(id + "en"), language));
                } else {
                    throw new Exception("Placeholder id does not exist");
                }

                i++; // Move past the closing bracket
            } else {
                expandedString.append(string.charAt(i));
            }
            i++;
        }

        // Add any remaining characters in the string
        while (i < string.length()) {
            expandedString.append(string.charAt(i));
            i++;
        }

        return expandedString.toString();
    }
}

 
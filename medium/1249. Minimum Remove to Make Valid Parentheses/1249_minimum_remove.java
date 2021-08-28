/*
stringbuilder
for every char
	if ( -> count++
	if ) -> count--
for every count left
	remove from string
ret string		
*/

class Solution {
    public String minRemoveToMakeValid(String s) {
        int times = 0;
        String result;
        StringBuilder stringbuilder = new StringBuilder();
        for (char character : s.toCharArray()) {
            if (character == '(') {
                stringbuilder.append(character);
                times++;
            } else if (character == ')') {
                times--;
                if (times >= 0) {
                	stringbuilder.append(character);
                }
                else {
                	times = 0;
                }
            } else {
                stringbuilder.append(character);
            }
        }
        while (times > 0) {
            int i = stringbuilder.lastIndexOf("(");
            stringbuilder.deleteCharAt(i);
            times--;
        }
        result = stringbuilder.toString();
        return result;
    }
}
//I approached the problem by initializing a StringBuilder to build the defanged IP address. 
//I iterated through each character in the input string using a for loop. 
//If the character was a period ('.'), I appended "[.]" to the StringBuilder; otherwise, 
//I appended the character itself. Finally, I returned the resulting string from the StringBuilder.

//Time: n
//Space: n
class Solution {
    public String defangIPaddr(String address) {
        if (address == null || address.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
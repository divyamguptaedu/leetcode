//Just created a map with 0, 1, 6, 8, 9 and set the start and end variable. 
//Now, while the start <= end, got the char at start and end,
//fetched the corresponding value of the start from the map, and then checked
//if value == null or end char is not equal to the value, then returned false, else true.

//Time: O(n)
//Space: O(1)
class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> m = new HashMap<>();
        m.put('0', '0');
        m.put('1', '1');
        m.put('6', '9');
        m.put('8', '8');
        m.put('9', '6');

        int start = 0;
        int end = num.length() - 1;

        while (start <= end) {
            char ch1 = num.charAt(start++);
            char ch2 = num.charAt(end--);

            Character other = m.get(ch1);
            if (other == null || ch2 != other) {
                return false;
            }
        }

        return true;
    }
}
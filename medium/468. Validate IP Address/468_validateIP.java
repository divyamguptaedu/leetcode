//I validate the given IP address string by checking if it contains 3 periods (for IPv4) or 7 colons (for IPv6). 
//For IPv4, I split the string into segments separated by periods and validate each segment. 
//I ensure each segment represents a number between 0 and 255 without leading zeros and 
//consists only of digits. 
//For IPv6, I split the string into segments separated by colons and validate each segment 
//as a hexadecimal number between 0 and 2^16. 

//Time: O(n)
//Space: O(1) we use string[] to split but that would be either O(4) or O(8) so thats constant.
class Solution {
    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        } else
            return "Neither";
    }

    public String validateIPv4(String IP) {
        String[] nums = IP.split("\\.", -1); // here \\ is added because just a simple dot is interpretted as something else.
        for (String x : nums) {
            // Validate integer in range (0, 255):
            // 1. length of chunk is between 1 and 3
            if (x.length() == 0 || x.length() > 3)
                return "Neither";
            // 2. no extra leading zeros
            if (x.charAt(0) == '0' && x.length() != 1)
                return "Neither";
            // 3. only digits are allowed
            for (char ch : x.toCharArray()) {
                if (!Character.isDigit(ch))
                    return "Neither";
            }
            // 4. less than 255
            if (Integer.parseInt(x) > 255)
                return "Neither";
        }
        return "IPv4";
    }

    public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF"; //digits, a-f, A-F
        for (String x : nums) {
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (x.length() == 0 || x.length() > 4)
                return "Neither";
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1)
                    return "Neither";
            }
        }
        return "IPv6";
    }
}
//I check if concatenating both strings in both orders results in the same string. 
//If not, I return an empty string. Then, I find the greatest common divisor (GCD) of the lengths of both strings. 
//Finally, I return a substring of str1 from index 0 to the GCD. 
//The GCD represents the maximum repeating pattern that divides both strings evenly.

//Time: O(m+n) where m and n are lengths of str1, and str2.
//Space: O(m+n)
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        int gcd = getGcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    public int getGcd(int a, int b) {
        if (b == 0)
            return a;
        return getGcd(b, a % b);
    }
}
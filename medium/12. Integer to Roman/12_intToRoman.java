//I converted an integer to a Roman numeral by iterating through predefined arrays of values and their corresponding Roman symbols. 
//For each value, I subtracted it from the input number as many times as possible, 
//appending the corresponding symbol to the result string each time. 
//I continued this process until the number was reduced to zero. 
//This approach ensures that the largest possible values are processed first, 
//adhering to Roman numeral construction rules.
//Time: constant
//Space: constant
class Solution {
    private static final int[] VALUES = {
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };
    private static final String[] SYMBOLS = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public String intToRoman(int number) {
        StringBuilder romanNumeral = new StringBuilder();
        
        // Loop through each value-symbol pair
        for (int i = 0; i < VALUES.length && number > 0; i++) {
            // Repeat while the current value can be subtracted from number
            while (VALUES[i] <= number) {
                number -= VALUES[i]; // Subtract the value from number
                romanNumeral.append(SYMBOLS[i]); // Append the corresponding symbol
            }
        }
        
        return romanNumeral.toString();
    }
}

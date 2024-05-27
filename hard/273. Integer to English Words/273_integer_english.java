//To convert a non-negative integer into its English words representation, 
//I used recursive helper functions to break down the number into billions, millions, thousands, hundreds, tens, and ones. 
//I mapped numbers to their corresponding English words using arrays for ones and tens. 
//The helper function divided the number by these large units and recursively processed each part. 
//The results were concatenated with appropriate labels (Billion, Million, Thousand, Hundred). 
//The main function handled the edge case for zero and initiated the recursive conversion, 
//ensuring the result was properly trimmed of any extra spaces.

//Time: O(n)
//Space: O(n)
class Solution {
    // Arrays to store English words for tens and ones places
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                     "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        
        return helper(num).trim(); // Initiate conversion and trim extra spaces
    }
    
    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        
        if (num >= 1000000000) { // Process billions
            sb.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        } else if (num >= 1000000) { // Process millions
            sb.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else if (num >= 1000) { // Process thousands
            sb.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num >= 100) { // Process hundreds
            sb.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num >= 20) { // Process tens
            sb.append(tens[num / 10]).append(" ").append(helper(num % 10));
        } else { // Process ones and teens
            sb.append(ones[num]);
        }
        
        return sb.toString().trim(); // Return the processed string without leading or trailing spaces
    }
}
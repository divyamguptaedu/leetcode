/*
Initialize an empty answer list.
Iterate on the numbers from 1...N1 ... N1...N.
For every number, if it is divisible by both 3 and 5, add FizzBuzz to the answer list.
Else, Check if the number is divisible by 3, add Fizz.
Else, Check if the number is divisible by 5, add Buzz.
Else, add the number.

Time: n
Space: constant
*/
class Solution {
    public List<String> fizzBuzz(int n) {

        // ans list
        List<String> ans = new ArrayList<String>();

        for (int num = 1; num <= n; num++) {

            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                // Divides by both 3 and 5, add FizzBuzz
                ans.add("FizzBuzz");
            } else if (divisibleBy3) {
                // Divides by 3, add Fizz
                ans.add("Fizz");
            } else if (divisibleBy5) {
                // Divides by 5, add Buzz
                ans.add("Buzz");
            } else {
                // Not divisible by 3 or 5, add the number
                ans.add(Integer.toString(num));
            }
        }

        return ans;
    }
}
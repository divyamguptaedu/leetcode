import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  

  int minLengthSubstring(String s, String t) {
    // Write your code here
    char[] charArray_s = s.toCharArray();
    char[] charArray_t = t.toCharArray();
    HashMap<Character, Integer> mapOne = new HashMap<>();
    for (char c : charArray_s) {
      if (mapOne.containsKey(c)) {
        mapOne.put(c, mapOne.get(c) + 1);
      } else {
        mapOne.put(c, 1);
      }
    }
    HashMap<Character, Integer> mapTwo = new HashMap<>();
    for (char c : charArray_t) {
      if (mapTwo.containsKey(c)) {
        mapTwo.put(c, mapTwo.get(c) + 1);
      } else {
        mapTwo.put(c, 1);
      }
    }
    for (char key : mapTwo.keySet()) {
      if (!mapOne.containsKey(key)) {
        return -1;
      }
      if (mapOne.get(key) < mapTwo.get(key)) {
        return -1; 
      }
    }
    return 1 + s.indexOf(charArray_t[0]) - s.indexOf(charArray_t[1]);
  }











  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  public void run() throws IOException {
    String s_1 = "dcbefebce";
    String t_1 = "fd";
    int expected_1 = 5;
    int output_1 = minLengthSubstring(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    String t_2 = "cbccfafebccdccebdd";
    int expected_2 = -1;
    int output_2 = minLengthSubstring(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) throws IOException {
    new Main().run();
  }
}
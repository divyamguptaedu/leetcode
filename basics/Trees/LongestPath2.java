import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.Stack;

public class Main2 {
    public static int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Initialize stack with a base value of 0
        int maxLength = 0;

        for (String line : lines) {

            int depth = line.lastIndexOf("\t") + 1;
            String name = line.substring(depth);

            while (stack.size() > depth + 1) {
                stack.pop();
            }

            int currentLength = stack.peek() + name.length() + 1; // +1 for "/"
            stack.push(currentLength);
            maxLength = Math.max(maxLength, currentLength - 1); // -1 to remove the trailing "/"
        }

        return maxLength;
    }

    @Test
    public void testFindLongestPath() {
        String input = "a\n\tb\n\t\tc\n\t\td\n\te\n\t\tf\n\t\t\tcow";
        int result = lengthLongestPath(input);
        assertEquals(9, result); // "a/e/f/cow" -> length 9
    }

    @Test
    public void testSkewedDirectory() {
        String input = "a\n\tb\n\t\tc";
        int result = lengthLongestPath(input);
        assertEquals(5, result); // "a/b/c" -> length 5
    }

    @Test
    public void testSingleFolder() {
        String input = "a";
        int result = lengthLongestPath(input);
        assertEquals(1, result); // No file, result is 0
    }

    @Test
    public void testNoFolder() {
        String input = "";
        int result = lengthLongestPath(input);
        assertEquals(0, result); // No folder, result is 0
    }

    @Test
    public void testMultipleRoots() {
        String input = "a\n\tb\n\t\tc\nx\n\ty\n\t\tz";
        int result = lengthLongestPath(input);
        assertEquals(5, result); // Both "a/b/c" and "x/y/z" -> length 5
    }

    @Test
    public void testFileInRoot() {
        String input = "file.txt";
        int result = lengthLongestPath(input);
        assertEquals(8, result); // "file.txt" -> length 8
    }
}

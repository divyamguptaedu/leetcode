//To find the next greater element with the same digits as the given number, 
//I converted the number to a character array. 
//I identified the rightmost digit that can be swapped to make the number larger by 
//scanning from the end until finding a digit smaller than its neighbor. 
//I then found the smallest digit on the right larger than this digit and swapped them. 
//After swapping, I reversed the digits following the initial digit to get the smallest possible order. 
//If the result exceeds 32-bit limits, I returned -1.

//Time: O(n)
//Space: O(n)
public class Solution {
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i = a.length - 2;
        
        // Find the first digit that can be swapped to form a larger number
        while (i >= 0 && a[i + 1] <= a[i]) {
            i--;
        }
        
        // If no such digit is found, return -1
        if (i < 0)
            return -1;
        
        // Find the smallest digit on the right larger than a[i]
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }
        
        // Swap the digits
        swap(a, i, j);
        
        // Reverse the sequence after the initial digit to get the smallest possible order
        reverse(a, i + 1);
        
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }
    
    // Helper method to reverse the character array from the start index
    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    
    // Helper method to swap two characters in the array
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

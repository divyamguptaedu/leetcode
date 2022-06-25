class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int x1 = Integer.parseInt(num1.substring(0, num1.indexOf("+")));
        int y1 = Integer.parseInt(num1.substring(num1.indexOf("+") + 1, num1.length()-1));
        int x2 = Integer.parseInt(num2.substring(0, num2.indexOf("+")));
        int y2 = Integer.parseInt(num2.substring(num2.indexOf("+") + 1, num2.length() - 1));
        
        int x3 = x1 * x2 + y1 * y2 * -1;
        int y3 = x1 * x2 + x2 * y1;
        
        return x3 + "+" + y3 + "i";
    }
}
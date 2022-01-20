"
Performance:
Runtime: 38 ms, faster than 8.07% of Java online submissions for Rotating the Box.
Memory Usage: 133.2 MB, less than 15.47% of Java online submissions for Rotating the Box.
"

 class Solution {
     public char[][] rotateTheBox(char[][] box) {
         int rowLength = box.length;
         int colLength = box[0].length;
         char[][] returnArray = new char[colLength][rowLength];
         for (int i = 0; i < rowLength; i++) {
             for (int j = 0; j < colLength; j++) {
                 returnArray[j][i] = box[rowLength - i - 1][j];
             }
         }
        
        for (int i = colLength - 1; i >= 0; i--) {
             for (int j = 0; j < rowLength; j++) {
                 if (returnArray[i][j] == '#') {
                     int current = i;
                     while (current + 1 < colLength && returnArray[current + 1][j] == '.') {
                         current++;
                     }
                     if (current != i) {
                         returnArray[current][j] = '#';
                         returnArray[i][j] = '.';
                     }
                 }
             }
         }
         return returnArray;
     }
 }
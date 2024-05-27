//To determine if four given points construct a valid square, 
//I computed the squared distances between each pair of points. 
//If the points form a square, there will be four equal distances (the sides) and two equal distances 
//(the diagonals) due to the nature of squares. 
//By comparing the counts of these distances, I checked if there are four equal distances and two twice-as-long distances, 
//indicating a square.

//Time: O(1)
//Space: O(1)
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // Calculate squared distances between each pair of points
        int[] arr = new int[6];
        arr[0] = (int) Math.pow(p1[0] - p2[0], 2) + (int) Math.pow(p1[1] - p2[1], 2);
        arr[1] = (int) Math.pow(p1[0] - p3[0], 2) + (int) Math.pow(p1[1] - p3[1], 2);
        arr[2] = (int) Math.pow(p1[0] - p4[0], 2) + (int) Math.pow(p1[1] - p4[1], 2);
        arr[3] = (int) Math.pow(p2[0] - p3[0], 2) + (int) Math.pow(p2[1] - p3[1], 2);
        arr[4] = (int) Math.pow(p2[0] - p4[0], 2) + (int) Math.pow(p2[1] - p4[1], 2);
        arr[5] = (int) Math.pow(p3[0] - p4[0], 2) + (int) Math.pow(p3[1] - p4[1], 2);

        // Find the minimum squared distance
        int min = arr[0];
        for (int i = 1; i < 6; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        // Count occurrences of minimum and twice-minimum distances
        int count1 = 0, count2 = 0;
        for (int i = 0; i < 6; i++) {
            if (arr[i] == min)
                count1++;
            else if (arr[i] == 2 * min)
                count2++;
        }

        // Check if the counts match square properties
        return count1 == 4 && count2 == 2;
    }
}
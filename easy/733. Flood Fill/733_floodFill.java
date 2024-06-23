//I used a depth-first search (DFS) approach. Initially, I checked if the starting pixel's color differed from the new color. 
//If they differed, I invoked a DFS starting from the initial pixel, 
//recursively updating pixels that were 4-directionally connected and had the same color as the starting pixel. 
//This ensured all connected regions of the same color were updated to the new color. 
//The DFS function recursively checked neighboring pixels, 
//modifying them if they matched the initial color, until all connected pixels were processed.

//TC: N
//SC: N
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) {
                dfs(image, r - 1, c, color, newColor);
            }
            if (c >= 1) {
                dfs(image, r, c - 1, color, newColor);
            }
            if (r + 1 < image.length) {
                dfs(image, r + 1, c, color, newColor);
            }
            if (c + 1 < image[0].length) {
                dfs(image, r, c + 1, color, newColor);
            }
        }
    }
}
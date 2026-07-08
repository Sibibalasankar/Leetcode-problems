// Last updated: 7/8/2026, 5:03:47 PM
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];

        // If the starting pixel already has the target color, no changes are needed
        if (initialColor != color) {
            dfs(image, sr, sc, initialColor, color);
        }

        return image;
    }

    private void dfs(int[][] image, int r, int c, int initialColor, int newColor) {
        // Boundary check and color match check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != initialColor) {
            return;
        }

        // Update color
        image[r][c] = newColor;

        // Recurse in 4 directions
        dfs(image, r - 1, c, initialColor, newColor); // Up
        dfs(image, r + 1, c, initialColor, newColor); // Down
        dfs(image, r, c - 1, initialColor, newColor); // Left
        dfs(image, r, c + 1, initialColor, newColor); // Right
    }
}
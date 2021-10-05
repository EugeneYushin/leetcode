package algo;

/**
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {
    /**
     * DFS solution
     * Time complexity: O(N*M) worst case
     * Space complexity: O(N*M) worst case
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc]) return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] img, int row, int col, int attr, int newAttr) {
        if (row >= 0 && row < img.length &&
                col >= 0 && col < img[0].length &&
                img[row][col] == attr) {
            img[row][col] = newAttr;
            dfs(img, row + 1, col, attr, newAttr);
            dfs(img, row - 1, col, attr, newAttr);
            dfs(img, row, col + 1, attr, newAttr);
            dfs(img, row, col - 1, attr, newAttr);
        }
    }
}

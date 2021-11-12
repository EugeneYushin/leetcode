package algo;

/**
 * https://leetcode.com/problems/rotate-image
 */
public class RotateImage {
    /**
     * Time complexity: O(N^2)
     * Space complexity: O(1)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int p4 = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];    // p3 -> p4
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];    // p2 -> p3
                matrix[j][n - i - 1] = matrix[i][j];  // p1 -> p2
                matrix[i][j] = p4;  // p4 -> p1
            }
        }
    }
}

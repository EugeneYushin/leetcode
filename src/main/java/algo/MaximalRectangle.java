package algo;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {
    /**
     * DP solution
     * Time complexity: O(r*c)
     * Space complexity: O(c)
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[] left = new int[m];    // foreach col, find the leftmost idx so that height[idx..i] >= height[col]
        int[] right = new int[m];   // foreach col, find the rightmost idx so that height[i..idx] >= height[col]
        int[] height = new int[m];  // num of "1" for a column till i

        // for initial height = 0, the leftmost index is the first one (0)
        Arrays.fill(right, m - 1);  // for initial height = 0, the rightmost index is the last one (m-1)

        int maxArea = 0;

        for (int r = 0; r < n; r++) {
            // update right
            int rightmostOne = m - 1;
            for (int c = m - 1; c >= 0; c--) {
                if (matrix[r][c] == '1') {
                    right[c] = Math.min(rightmostOne, right[c]);
                } else {
                    right[c] = m - 1;
                    rightmostOne = c - 1;
                }
            }

            // proceed with left and height
            int leftmostOne = 0;
            for (int c = 0; c < m; c++) {
                if (matrix[r][c] == '1') {
                    left[c] = Math.max(leftmostOne, left[c]);
                    height[c]++;
                    maxArea = Math.max(maxArea, (right[c] - left[c] + 1) * height[c]);
                } else {
                    left[c] = 0;
                    leftmostOne = c + 1;
                    height[c] = 0;
                }
            }
        }

        return maxArea;
    }
}

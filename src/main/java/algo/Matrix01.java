package algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/01-matrix/
 */
public class Matrix01 {
    /**
     * DP solution, 2 passes
     * top-down, left-right: check upper and left neighbours
     * bottom-up, right-left: check right and lower neighbours
     *
     * Time complexity: O(n*m)
     * Space complexity: O(1)
     */
    public int[][] updateMatrix(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        int maxValue = mat.length * mat[0].length;  // mat is binary matrix

        // init + top-down, left-right
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (mat[i][j] == 1) {
                    int upper = i == 0 ? maxValue : dp[i - 1][j];
                    int left = j == 0 ? maxValue : dp[i][j - 1];
                    dp[i][j] = Math.min(upper, left) + 1;
                }
            }
        }

        // bottom-up, right-left
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (dp[i][j] > 0) {
                    int right = j == dp[0].length - 1 ? dp[i][j] : dp[i][j + 1];
                    int lower = i == dp.length - 1 ? dp[i][j] : dp[i + 1][j];
                    dp[i][j] = Math.min(dp[i][j], Math.min(right, lower) + 1);
                }
            }
        }

        return dp;
    }


    /**
     * BFS solution, put all 0s to queue then all their adjacent neighbours, and so on
     *
     * Time complexity: O(m*n), as we add to the queue only when current distance > calculated one,
     * and as we go from all 0s, then to all their neighbours (and so on), we won't add the same element to the queue
     * more than once.
     * Space complexity: O(m*n)
     */
    public int[][] updateMatrix_bfs(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();

        int[] shiftRow = {-1, 1, 0, 0};
        int[] shiftCol = {0, 0, -1, 1};

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (mat[i][j] == 0) {
                    // res[] is already initiated with 0s
                    q.offer(new int[]{i, j});
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] rc = q.poll();
            int row = rc[0];
            int col = rc[1];

            int currentDistance = res[row][col] + 1;

            for (int i = 0; i < 4; i++) {
                int neighbourRow = row + shiftRow[i];
                int neighbourCol = col + shiftCol[i];
                if (
                        neighbourRow >= 0 && neighbourRow < mat.length &&
                                neighbourCol >= 0 && neighbourCol < mat[0].length &&
                                res[neighbourRow][neighbourCol] > currentDistance
                ) {
                    res[neighbourRow][neighbourCol] = currentDistance;
                    q.offer(new int[]{neighbourRow, neighbourCol});
                }
            }
        }

        return res;
    }
}

package algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {
    /**
     * BFS solution
     * Time complexity: O(n*m)
     * Space complexity: O(n*m)
     */
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
                else if (grid[i][j] == 1) freshCount++;
            }
        }

        if (freshCount == 0) return 0;
        if (q.isEmpty()) return -1;

        int minutes = 0;
        int[] shiftRows = {1, -1, 0, 0};
        int[] shiftCols = {0, 0, 1, -1};

        q.offer(null);  // minutes shift

        while (!q.isEmpty()) {
            int[] rc = q.poll();

            if (rc == null) {
                if (!q.isEmpty()) {
                    minutes++;
                    q.offer(null);
                }
            } else {
                int row = rc[0];
                int col = rc[1];
                for (int i = 0; i < 4; i++) {
                    int nRow = row + shiftRows[i];
                    int nCol = col + shiftCols[i];
                    if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == 1) {
                        q.offer(new int[]{nRow, nCol});
                        grid[nRow][nCol] = 2;
                        freshCount--;
                    }
                }
            }
        }

        return freshCount > 0 ? -1 : minutes;
    }
}

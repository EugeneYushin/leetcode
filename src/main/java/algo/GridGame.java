package algo;

/**
 * https://leetcode.com/contest/weekly-contest-260/problems/grid-game/
 */
public class GridGame {
    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public long gridGame(int[][] grid) {
        long topSum = 0;
        long bottomSum = 0;

        for (int a : grid[0]) {
            topSum += a;
        }

        long points = Long.MAX_VALUE;

        for (int i = 0; i < grid[0].length; i++) {
            topSum -= grid[0][i];
            points = Math.min(points, Math.max(topSum, bottomSum));
            bottomSum += grid[1][i];
        }

        return points;
    }
}

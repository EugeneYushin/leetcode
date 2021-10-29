package algo;

public class DungeonGame {
    /**
     * DP solution, bottom-top right-left, store the number of demons
     * Time complexity: O(n*m)
     * Space complexity: O(n*m)
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        for (int r = 0; r < dp.length - 2; r++) {
            dp[r][dp[0].length - 1] = Integer.MIN_VALUE;
        }
        for (int c = 0; c < dp[0].length - 2; c++) {
            dp[dp.length - 1][c] = Integer.MIN_VALUE;
        }

        for (int r = dungeon.length - 1; r >= 0; r--) {
            for (int c = dungeon[0].length - 1; c >=0; c--) {
                int demons = dungeon[r][c] + Math.max(dp[r + 1][c], dp[r][c + 1]);
                dp[r][c] = Math.min(demons, 0);
            }
        }

        return Math.abs(dp[0][0]) + 1;
    }
}

package algo;

/**
 * https://leetcode.com/problems/champagne-tower/
 */
public class ChampagneTower {
    /**
     * DP, reduced space complexity
     * Time complexity: O(N^2), N - number of rows
     * Space complexity: O(N)
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) return 0;
        double[] glasses = new double[query_row + 1];  // +1 to handle overflow of excess for the last row
        glasses[0] = poured;

        for (int row = 0; row < query_row; row++) {
            // from right to left
            for (int col = row; col >= 0; col--) {
                // x0
                // x1 x2      ==> [x0, x1, x2, x3, x4, x5, ... xN]
                // x3 x4 x5
                // steps: x0 to (=)x2 and (+)x1; x2 to (+)x5 and (=)x4, x1 to (+)x4 amd (=)x3
                if (glasses[col] > 1) {
                    double flow = (glasses[col] - 1) / 2;
                    // add to right (next row)
                    glasses[col + 1] += flow;
                    // set value below, as we traverse from right to left - we replace head eventually
                    // and add value to the one which was set on the previous step (col + 1)
                    glasses[col] = flow;
                } else {
                    // backtrack the value from previous step
                    glasses[col] = 0;
                }
            }
        }

        return Math.min(glasses[query_glass], 1);
    }

    /**
     * Time complexity: O(N^2), N - number of rows
     * Space complexity: O(N^2)
     */
    public double champagneTower_dp(int poured, int query_row, int query_glass) {
        if (poured == 0) return 0;
        double[][] glasses = new double[101][101];  // 101 to handle overflow of excess for the last 100th row
        glasses[0][0] = poured;

        for (int row = 0; row <= query_row; row++) {
            for (int col = 0; col <= query_glass; col++) {
                double flow = (glasses[row][col] - 1) / 2;
                if (flow > 0) {
                    glasses[row + 1][col] += flow;
                    glasses[row + 1][col + 1] += flow;
                }
            }
        }

        return Math.min(glasses[query_row][query_glass], 1);
    }
}

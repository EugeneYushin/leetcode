package algo;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    /**
     * DP solution, bottom to top
     * Time complexity: O(N*(N+1)/2)
     * Space complexity: O(N)
     * N - length of triangle
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = row.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }

    /**
     * DP solution, top to bottom
     * dp:      ....     2
     * row:     ...   3, 4
     * new dp:  ...   5, 6
     * row:     .. 6, 5, 7
     * new dp:  ..11,10,13
     * <p>
     * Time complexity: O(N*(N+1)/2)
     * Space complexity: O(N)
     * N - length of triangle
     */
    public int minimumTotal_topBottom(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[dp.length - 1] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);

            dp[dp.length - 1 - i] = row.get(0) + dp[dp.length - i]; // set first

            int j = 1;
            while (j < row.size() - 1) {
                dp[dp.length - 1 - i + j] = row.get(j) + Math.min(dp[dp.length - 1 - i + j], dp[dp.length - i + j]);
                j++;
            }

            dp[dp.length - 1] += row.get(j);    // set last
        }

        int min = dp[0];
        for (int i : dp) {
            min = Math.min(min, i);
        }

        return min;
    }
}

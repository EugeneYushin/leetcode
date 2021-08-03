package algo;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[] {1, 2};
        int i = 3;
        while (i <= n) {
            // checking for an odd index
            dp[(i + 1) & 1] = dp[0] + dp[1];
            i++;
        }

        return dp[(n + 1) & 1];
    }
}

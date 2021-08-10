package algo;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    /**
     * DP solution
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];

        // there's no need to store all values in DP, only the last two maximums
        int[] dp = new int[] {nums[0], Math.max(nums[0], nums[1])};
        for (int i = 2; i < nums.length; i++) {
            dp[i & 1] = Math.max(dp[i & 1] + nums[i], dp[(i - 1) & 1]);
        }

        return Math.max(dp[0], dp[1]);
    }
}

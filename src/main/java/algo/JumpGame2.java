package algo;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        return jump_linear(nums);
    }

    public int jump_dp(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                int index = Math.min(i + j, nums.length - 1);
                dp[index] = Math.min(dp[i] + 1, dp[index]);
            }
        }

        return dp[dp.length - 1];
    }

    public int jump_linear(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int jumps = 0;
        int maxIndex = nums[0];
        int localEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex >= nums.length - 1) return ++jumps;

            if (i == localEnd) {
                localEnd = maxIndex;
                jumps++;
            }
        }

        return jumps;
    }
}

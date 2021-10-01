package algo;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */
public class PartitionToKEqualSumSubsets {
    /**
     * Back-tracking solution
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true;

        int totalSum = 0;
        for (int i : nums) totalSum += i;

        if (totalSum % k != 0) return false;

        return canPartition(totalSum / k, 0, k, nums, new boolean[nums.length], 0);
    }

    private boolean canPartition(int targetSum, int currentSum, int k, int[] nums, boolean[] used, int start) {
        if (k == 1) return true;
        if (currentSum > targetSum) return false;
        if (currentSum == targetSum) return canPartition(targetSum, 0, k - 1, nums, used, 0);

        for (int i = start; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (canPartition(targetSum, currentSum + nums[i], k, nums, used, i + 1)) return true;
                used[i] = false;
            }
        }

        return false;
    }
}

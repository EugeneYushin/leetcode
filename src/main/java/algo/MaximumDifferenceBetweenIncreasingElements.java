package algo;

/**
 * https://leetcode.com/problems/maximum-difference-between-increasing-elements/
 */
public class MaximumDifferenceBetweenIncreasingElements {
    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                maxDiff = Math.max(maxDiff, nums[j] - nums[i]);
            } else {
                i = j;
            }
        }

        return maxDiff;
    }
}

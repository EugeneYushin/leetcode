package algo;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int maxProduct(int[] nums) {
        int product = 1;
        int maxP = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            maxP = Math.max(maxP, product);
            product = product == 0 ? 1 : product;
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            maxP = Math.max(maxP, product);
            product = product == 0 ? 1 : product;
        }

        return maxP;
    }
}

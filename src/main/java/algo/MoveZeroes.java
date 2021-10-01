package algo;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    /**
     * 2 pointers
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) nums[i] = 0;    // optimization
                j++;
            }
        }

        // without optinization
        // if (j > 0) while (j < nums.length) nums[j++] = 0;
    }
}

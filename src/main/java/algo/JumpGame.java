package algo;

public class JumpGame {
    public boolean canJump(int[] nums) {
        return canJumpEager(nums);
    }

    public boolean canJumpExponential(int[] nums) {
        return canJumpFromExponential(0, nums);
    }

    /**
     * time complexity: O(2^n)
     * memory complexity: O(n) to maintain the stack
     */
    private boolean canJumpFromExponential(int pos, int[] nums) {
        if (pos == nums.length - 1) return true;

        int longestJump = Math.min(pos + nums[pos], nums.length - 1);
        for (int i = pos + 1; i <= longestJump; i++) {
            if (canJumpFromExponential(i, nums)) return true;
        }

        return false;
    }

    /**
     * Dynamic Programming version, bottom-up
     * Time complexity: O(n^2)
     * Space complexity: O(2n) stack + index array => O(n)
     */
    public boolean canJumpDP(int[] nums) {
        Index[] idx = new Index[nums.length];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = Index.BAD;
        }
        idx[idx.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int longestJump = Math.min(nums[i] + i, nums.length - 1);
            for (int j = i + 1; j <= longestJump; j++) {
                if (idx[j] == Index.GOOD) {
                    idx[i] = Index.GOOD;
                    break;
                }
            }
        }

        return idx[0] == Index.GOOD;
    }

    public enum Index {GOOD, BAD}

    /**
     * - go from right to left
     * - maintain the leftmost Good index
     * - on the current step check if it's possible to reach the leftmost Good index
     * - adjust the leftmost Good index if previous step is true
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean canJumpEager(int[] nums) {
        int leftMostGood = nums.length - 1;
        for (int i = leftMostGood - 1; i >= 0; i--) {
            if (nums[i] + i >= leftMostGood) leftMostGood = i;
        }
        return leftMostGood == 0;
    }
}

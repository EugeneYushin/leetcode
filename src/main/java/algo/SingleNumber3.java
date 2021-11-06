package algo;

/**
 * https://leetcode.com/problems/single-number-iii/
 */
public class SingleNumber3 {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int[] singleNumber(int[] nums) {
        int norMask = 0;
        for (int i : nums) {
            norMask ^= i;
        }

        // find rightmost set bit using two's complement
        norMask &= -norMask;

        // divide nums into 2 buckets with respect to norMask-th set bit
        int[] res = new int[2];
        for (int i : nums) {
            if ((i & norMask) == 0) res[0] ^= i;
            else res[1] ^= i;
        }

        return res;
    }
}

package algo;

/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 *
 * The problem can be re-phrased to find common bit prefix
 */
public class BitwiseANDOfNumbersRange {
    /**
     * Brian Kernighan's algo
     * https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
     *
     * The beauty of this algo is that we need to iterate over set (1) bits of right integer only
     */
    public int rangeBitwiseAnd_BKalgo(int left, int right) {
        while (right > left) {
            right &= (right - 1);   // flip rightmost set bit
        }
        return right;   // prefix
    }

    /**
     * Bit manipulation
     * Time complexity: O(logL), we do left/2 for each iteration
     * Space complexity: O(1)
     */
    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0) return 0;

        int multiplier = 0;
        while (left != right) { // both part of left and right are the same, (left & right) will be no-op
            // one of integers is odd, the other is even, last bit will always be 0 after applying &
            left >>= 1;
            right >>= 1;
            multiplier++;
        }

        // now we need to shift the common part to the original magnitude
        return left << multiplier;
    }

    /**
     * Time complexity: O(right - left)
     * Space complexity: O(1)
     */
    public int rangeBitwiseAnd_bruteforce(int left, int right) {
        if (left == right) return left;

        int res = left;
        for (int i = left + 1; i <= right && res != 0; i++) {
            res &= i;
            if (i == Integer.MAX_VALUE) break;
        }

        return res;
    }
}

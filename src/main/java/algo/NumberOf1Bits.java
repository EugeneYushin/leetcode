package algo;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value

    /**
     * Time complexity: O(logN) worst case, iterates over set bits only, skips the rest
     * Space complexity: O(1)
     */
    public int hammingWeight_log(int n) {
        int count = 0;
        while (n != 0) {    // MIN_VALUE has 1000 0... representation (cyclic MAX_VALUE + 1)
            n &= (n - 1);
            count++;
        }

        return count;
    }
}

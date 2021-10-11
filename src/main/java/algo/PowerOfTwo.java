package algo;

/**
 * https://leetcode.com/problems/power-of-two/
 */
public class PowerOfTwo {
    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * Time complexity: O(logN)
     * Space complexity: O(1)
     */
    public boolean isPowerOfTwo_log(int n) {
        int count = 0;
        while (n > 0 && count < 2) {
            if ((n & 1) == 1) count++;
            n >>= 1;
        }

        return count == 1;
    }
}

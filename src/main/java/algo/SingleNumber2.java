package algo;

/**
 * https://leetcode.com/problems/single-number-ii/
 */
public class SingleNumber2 {
    /**
     * Time complexity: O(n)
     * Space complexity: O(32) = O(1)
     */
    public int singleNumber(int[] nums) {
        int[] resBinary = new int[32];

        for (int num : nums) {
            while (num != 0) {
                int rightmostSetBit = num & -num;
                int rightmostSetBitIndex = rightmostSetBit == Integer.MIN_VALUE ? 31 :
                        ((int) (Math.log10(num & -num) / Math.log10(2)));
                resBinary[rightmostSetBitIndex] = (resBinary[rightmostSetBitIndex] + 1) % 3;
                num &= (num - 1);
            }
        }

        int res = 0;
        boolean isNegative = resBinary[31] == 1;
        int comparator = isNegative ? 0 : 1;
        for (int i = 0; i < resBinary.length - 1; i++) {
            if (resBinary[i] == comparator) res += Math.pow(2, i);
        }

        return isNegative ? -1 * (res + 1) : res;
    }
}

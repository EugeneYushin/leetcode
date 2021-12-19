package algo;

/**
 * https://leetcode.com/problems/numbers-at-most-n-given-digit-set/
 */
public class NumbersAtMostNGivenDigitSet {
    /**
     * DP
     * Time complexity: O(logN)
     * Space complexity: O(logN)
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String nStr = String.valueOf(n);
        int pwr = nStr.length();
        int[] dp = new int[pwr + 1];
        dp[dp.length - 1] = 1;  // for equality case

        for (int p = pwr - 1; p >= 0; p--) {    // log10 time
            int iDigit = nStr.charAt(p) - '0';

            for (String d : digits) {   // constant time O(9)
                int dDigit = Integer.parseInt(d);

                if (dDigit < iDigit) {
                    // include all cases
                    dp[p] += Math.pow(digits.length, pwr - p - 1);
                } else if (dDigit == iDigit) {
                    // it's actually (1 * prev)
                    dp[p] += dp[p + 1];
                }
            }
        }

        for (int i = 1; i < dp.length - 1; i++) {
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
    }
}

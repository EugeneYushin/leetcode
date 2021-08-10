package algo;

/**
 * https://leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {
    /**
     * DP solution (memory optimized)
     * Time complexity: O(M*N)
     * Space complexity: O(N)
     *  N - length of smaller string
     *  M - length of bigger string
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        else if (s1.isEmpty()) return s3.equals(s2);
        else if (s2.isEmpty()) return s3.equals(s1);

        String small;
        String big;

        if (s1.length() > s2.length()) {
            big = s1;
            small = s2;
        } else {
            big = s2;
            small = s1;
        }

        boolean[] dp = new boolean[small.length() + 1];

        // base
        dp[0] = true;
        for (int i = 0; i < small.length(); i++) {
            if (s3.charAt(i) == small.charAt(i) && dp[i]) {
                dp[i + 1] = true;
            }
        }

        // iterate
        for (int i = 0; i < big.length(); i++) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] && big.charAt(i) == s3.charAt(j + i)) dp[j] = true;
                else dp[j] = j > 0 && dp[j - 1] && small.charAt(j - 1) == s3.charAt(j + i);
            }
        }

        return dp[dp.length - 1];
    }

    /**
     * DP solution
     * Time complexity: O(M*N)
     * Space complexity: O(M*N)
     * N - length of s1
     * M - length of s2
     */
    public boolean isInterleave_dp(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        else if (s1.isEmpty()) return s3.equals(s2);
        else if (s2.isEmpty()) return s3.equals(s1);

        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];

        // base
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s3.charAt(i) == s1.charAt(i) && dp[0][i]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (s3.charAt(i) == s2.charAt(i) && dp[i][0]) {
                dp[i + 1][0] = true;
            }
        }

        // iterate
        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                // can we proceed with s1?
                if (dp[row][col - 1] && s3.charAt(row + col - 1) == s1.charAt(col - 1)) {
                    dp[row][col] = true;
                }
                // or maybe with s2?
                else if (dp[row - 1][col] && s3.charAt(row + col - 1) == s2.charAt(row - 1)) {
                    dp[row][col] = true;
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public boolean isInterleave_bruteForce(String s1, String s2, String s3) {
        if (s1.isEmpty()) return s3.equals(s2);
        else if (s2.isEmpty()) return s3.equals(s1);

        if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
            return isInterleave_bruteForce(s1.substring(1), s2, s3.substring(1)) ||
                    isInterleave_bruteForce(s1, s2.substring(1), s3.substring(1));
        } else if (s1.charAt(0) == s3.charAt(0)) {
            return isInterleave_bruteForce(s1.substring(1), s2, s3.substring(1));
        } else if (s2.charAt(0) == s3.charAt(0)) {
            return isInterleave_bruteForce(s1, s2.substring(1), s3.substring(1));
        } else {
            return false;
        }
    }
}

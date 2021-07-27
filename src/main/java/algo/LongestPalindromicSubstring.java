package algo;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        return longestPalindrome_dp(s);
    }

    public String longestPalindrome_insideOut(String s) {
        if (s.length() < 2) return s;
        else if (s.length() == 2) return s.charAt(0) == s.charAt(1) ? s : s.substring(0, 1);

        int midIdx = s.length() / 2;
        int offset = 0;
        boolean isPalindrome = true;

        StringBuilder currentPalindrome = new StringBuilder();
        currentPalindrome.append(s.charAt(midIdx));

        while (isPalindrome && midIdx + offset < s.length() - 1) {
            offset++;
            if (s.charAt(midIdx - offset) == s.charAt(midIdx + offset)) {
                currentPalindrome.insert(0, s.charAt(midIdx - offset));
                currentPalindrome.append(s.charAt(midIdx + offset));
            } else {
                isPalindrome = false;
            }
        }

        if (offset == midIdx && isPalindrome) return currentPalindrome.toString();
        else if (midIdx - offset == 1 && isPalindrome) {
            if (currentPalindrome.charAt(0) == s.charAt(0)) {
                currentPalindrome.append(s.charAt(0));
            }
            return currentPalindrome.toString();
        } else {
            String left = longestPalindrome(s.substring(0, s.length() - 1));
            String right = longestPalindrome(s.substring(1));
            String maxSubPalindrome = left.length() > right.length() ? left : right;
            return maxSubPalindrome.length() > currentPalindrome.length() ? maxSubPalindrome : currentPalindrome.toString();
        }
    }

    public String longestPalindrome_dp(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0 ; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) dp[i][j] = true;
                else if (j - i == 1) dp[i][j] = s.charAt(i) == s.charAt(j);
                else {
                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        // smart way to find the answer in DP storage
        // * * * ?          * * ? *            * ? * *
        // - * * *   then   - * * ?     then   - * ? *  ...
        // - - * *          - - * *            - - * ?
        // - - - *          - - - *            - - - *
        for (int i = dp[0].length - 1; i >= 0; i--) {
            int col = i;
            int row = 0;

            while (col < dp[0].length) {
                if (dp[row][col]) return s.substring(row, col + 1);
                col++;
                row++;
            }
        }

        // should never be called
        return s.substring(0, 1);
    }

    public static void main(String[] args) {
        boolean[][] arr = new boolean[10][10];

        for (int i = 0; i < arr.length; i++) {
            int col = i;
            int row = 0;

            while (col >= 0) {
                System.out.println("row,col = " + row + "," + col);
                col--;
                row++;
            }
        }
    }
}




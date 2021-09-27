package algo;

public class LargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][][] dp = new int[n][n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new int[]{1, 0, 0, 0, 0};    // value, max left, max up, max right, max down
            }
        }
        for (int[] yx : mines) {
            dp[yx[0]][yx[1]] = new int[]{0, 0, 0, 0, 0};
        }

        // set max count of 1 occurrences to the left
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j][1] = dp[i][j - 1][0] > 0 ? dp[i][j - 1][1] + 1 : 0;
            }
        }

        // set max count of 1 occurrences to the up
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][2] = dp[i - 1][j][0] > 0 ? dp[i - 1][j][2] + 1 : 0;
            }
        }

        // set max count of 1 occurrences to the right
        for (int i = 0; i < n; i++) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j][3] = dp[i][j + 1][0] > 0 ? dp[i][j + 1][3] + 1 : 0;
            }
        }

        // set max count of 1 occurrences to the bottom
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j][4] = dp[i + 1][j][0] == 1 ? dp[i + 1][j][4] + 1 : 0;
            }
        }

        prettyPrint(dp);

        int k = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int currentK = dp[i][j][0] == 1 ? Math.min(dp[i][j][1], Math.min(dp[i][j][2], Math.min(dp[i][j][3], dp[i][j][4]))) + 1 : 0;
                k = Math.max(currentK, k);
            }
        }

        return k;
    }

    public void prettyPrint(int[][][] dp) {
        for (int[][] r : dp) {
            for (int[] c: r) {
                System.out.print(c[0]+ "(l:" + c[1] + ",u:" + c[2] + ",r:" + c[3] + ",b:" + c[4] + ")    ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        LargestPlusSign cl = new LargestPlusSign();
        System.out.println(cl.orderOfLargestPlusSign(6, new int[][] {new int[] {4, 2}}));
        System.out.println(cl.orderOfLargestPlusSign(1, new int[][] {new int[] {0, 0}}));
    }
}

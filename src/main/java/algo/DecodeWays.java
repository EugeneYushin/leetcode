package algo;

public class DecodeWays {
    public int numDecodings(String s) {
        return numDecodings_memoized(s);
    }

    public int numDecodings_recursive(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;   // can't decode '08'
        else if (s.length() == 1) {
            return (s.charAt(0) > '0' && s.charAt(0) <= '9') ? 1 : 0;
        } else if (s.length() == 2) {
            if (s.charAt(1) == '0' && s.charAt(0) > '2') return 0; // '10' or '20' are only valid strings with 0
            else if (s.equals("10") || s.equals("20")) return 1;
            else if (Integer.parseInt(s) > 26) return 1;    // '27' -> (2 7)
            else return 2;  // '26' -> (2 6) (26)
        } /*else {
            return numDecodings(s.substring(1)) + Integer.parseInt(s.substring(0, 2)) < 27 ? numDecodings(s.substring(2)) : 0;
        }*/

        int res = numDecodings_recursive(s.substring(1));
        if (Integer.parseInt(s.substring(0, 2)) < 27) res += numDecodings_recursive(s.substring(2));
        return res;
    }

    public int numDecodings_memoized(String s) {
        int[] dp = new int[s.length()];
        dp[dp.length - 1] = isValid(s.charAt(dp.length - 1)) ? 1 : 0;
        if (s.length() == 1) return dp[0];

        if (isValid(s.charAt(dp.length - 2), s.charAt(dp.length - 1)) && s.charAt(dp.length - 1) != '0') {
            dp[dp.length - 2] = 2;
        } else if (isValid(s.charAt(dp.length - 2), s.charAt(dp.length - 1))) {
            dp[dp.length - 2] = 1;
        } else if (isValid(s.charAt(dp.length - 2)) && isValid(s.charAt(dp.length - 1))) {
            dp[dp.length - 2] = 1;
        } else {
            dp[dp.length - 2] = 0;
        }

        for (int i = dp.length - 3; i >= 0; i--) {
            if (isValid(s.charAt(i), s.charAt(i + 1))) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else if (isValid(s.charAt(i)) && isValid(s.charAt(i + 1))) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = 0;
            }
        }

        return dp[0];
    }

    private boolean isValid(char... c) {
        return c[0] != '0' && Integer.parseInt(new String(c)) < 27;
    }

    public static void main(String[] args) {
        String s = "8";
        System.out.println("s = " + s);

        Character c1 = '2';
        Character c2 = '1';
        int i = c1 + c2;
        System.out.println("i = " + i);
    }
}

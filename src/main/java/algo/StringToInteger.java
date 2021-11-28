package algo;

public class StringToInteger {
    /**
     * Time complexity: O(logN), log with base 10
     * Space complexity: O(1)
     */
    public int myAtoi(String s) {
        int result = 0;
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i == s.length()) return result;

        boolean isNegative = false;

        if (s.charAt(i) == '-') {
            isNegative = true; i++;
        }
        else if (s.charAt(i) == '+') {
            i++;
        }
        if (i == s.length()) return result;

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int j = s.charAt(i) - '0';
            if (isNegative) {
                j *= -1;
                if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && j <= Integer.MIN_VALUE % 10)
                    return Integer.MIN_VALUE;
            } else {
                if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && j >= Integer.MAX_VALUE % 10)
                    return Integer.MAX_VALUE;
            }
            result = result * 10 + j;
            i++;
        }

        return result;
    }
}

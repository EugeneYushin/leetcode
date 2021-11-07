package algo;

/**
 * https://leetcode.com/problems/multiply-strings/
 * https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
 */
public class MultiplyStrings {
    /**
     * Time complexity: O(n*m)
     * Space complexity: O(n+m)
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] pos = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = pos[i + j + 1] + product;

                pos[i + j] += sum / 10;
                pos[i + j + 1] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // skip leading 0s
            if (!(sb.length() == 0 && p == 0)) sb.append(p);
        }

        return sb.toString();
    }
}

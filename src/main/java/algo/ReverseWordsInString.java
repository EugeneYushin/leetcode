package algo;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInString {
    /**
     * Time complexity: O(N)
     * Space complexity: O(1) not counting extra space to store result
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            int end = i;
            if (i < 0) break;

            while (i >= 0 && s.charAt(i) != ' ') i--;
            int start = i + 1;

            while (start <= end) sb.append(s.charAt(start++));
            sb.append(' ');
        }

        sb.setLength(sb.length() - 1);

        return sb.toString();
    }

    /**
     * Naive, split and reverse
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public String reverseWords_naive(String s) {
        String[] strings = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].isEmpty()) {
                sb.append(strings[i]);
                sb.append(" ");
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}

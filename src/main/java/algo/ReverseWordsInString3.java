package algo;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInString3 {
    /**
     * Time complexity: O(N)
     * Space complexity: O(1) not counting space for result
     */
    public String reverseWords(String s) {
        char[] sb = new char[s.length()];
        int c = 0;

        for (int i = 0; i < s.length(); i++) {
            int start = i;
            while (i < s.length() && s.charAt(i) != ' ') i++;

            int end = i - 1;
            while (start <= end) {
                sb[c++] = s.charAt(end--);
            }

            if (i < s.length()) sb[c++] = ' ';
        }

        return new String(sb);
    }
}

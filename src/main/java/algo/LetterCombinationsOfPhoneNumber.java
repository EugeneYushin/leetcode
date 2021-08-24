package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber {
    private final char[][] mapping = new char[][]{
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'}
    };

    /**
     * Backtracking solution
     * Time complexity: O(N*4^N)
     * Space complexity: O(N) to hold a recursion stack
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.emptyList();

        List<String> res = new LinkedList<>();
        letterCombinations_backtracking(digits, 0, new StringBuilder(), res);
        return res;
    }

    public void letterCombinations_backtracking(String digits, int index, StringBuilder sb, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : mapping[digits.charAt(index) - '2']) {
            sb.append(c);
            letterCombinations_backtracking(digits, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);   // backtrack: remove the char from current mapping for next iteration
        }
    }

    /**
     * Time complexity: O(N*4^N), N times to (3-4)^N inner loops (cartesian of 3 or 4 letters for each N digit)
     * Space complexity: O(1), or O(4^N) if we consider space to store result
     */
    public List<String> letterCombinations_iterative(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.emptyList();
        LinkedList<String> result = new LinkedList<>();
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            while (result.peek().length() == i) {   // i==0: a,b,c|STOP|ad,ae,...
                String s = result.poll();
                for (char c : mapping[digits.charAt(i) - '2']) {
                    result.add(s + c);
                }
            }
        }

        return result;
    }
}

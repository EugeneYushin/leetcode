package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class LetterCasePermutation {
    /**
     * Recursion with backtracking
     * Time complexity: O(2^n)
     * Space complexity: O(n) for intermediate string buffer + O(n) for recursion = O(n)
     */
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int start, StringBuilder sb, List<String> result) {
        if (start == s.length()) {
            result.add(sb.toString());
            return;
        }

        char c = s.charAt(start);
        sb.append(Character.toLowerCase(c));
        backtrack(s, start + 1, sb, result);
        sb.setLength(sb.length() - 1);  // more performant then `deleteCharAt`

        if (!Character.isDigit(c)) {
            sb.append(Character.toUpperCase(c));
            backtrack(s, start + 1, sb, result);
            sb.setLength(sb.length() - 1);
        }
    }

    /**
     * Iterative
     * Time complexity: O(2^n)
     * Space complexity: O(2^n)
     */
    public List<String> letterCasePermutation_iterative(String s) {
        List<StringBuilder> builders = new ArrayList<>();
        builders.add(new StringBuilder(s.length()));

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                for (StringBuilder sb : builders) {
                    sb.insert(0, c);
                }
            } else {
                int size = builders.size();
                for (int j = 0; j < size; j++) {
                    StringBuilder sb = builders.get(j);
                    StringBuilder extra = new StringBuilder(sb);
                    extra.insert(0, Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));

                    sb.insert(0, c);
                    builders.add(extra);
                }
            }
        }

        List<String> result = new LinkedList<>();
        for (StringBuilder sb : builders) {
            result.add(sb.toString());
        }

        return result;
    }
}

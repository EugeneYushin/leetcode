package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-duplicate-substring/
 */
public class LongestDuplicateSubstring {
    /**
     * Rolling hash
     */
    public String longestDupSubstring(String S) {
        String ans = "";
        int left = 1;
        int right = S.length() - 1;

        while (left <= right) {
            int m = left + (right - left) / 2;
            String dup = getDup(m, S);

            if (dup != null) {
                ans = dup;
                left = m + 1;
            } else right = m - 1;
        }
        return ans;
    }

    private String getDup(int size, String s) {
        long H = hash(s.substring(0, size));
        Set<Long> set = new HashSet<>();
        set.add(H);

        long pow = 1;
        // set the power of pattern
        for (int i = 1; i < size; i++) pow = pow * 31;

        for (int i = size; i < s.length(); i++) {
            H = nextHash(pow, H, s.charAt(i - size), s.charAt(i));
            if (!set.add(H)) return s.substring(i - size + 1, i + 1);
        }
        return null;
    }

    private long hash(String s) {
        long h = 0;
        long a = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            h += (ch - 'a' + 1) * a;
            a *= 31;
        }
        return h;
    }

    private long nextHash(long pow, long hash, char left, char right) {
        return (hash - (left - 'a' + 1) * pow) * 31 + (right - 'a' + 1);
    }

    /**
     * Use Set for hashing
     * Memory Limit Exceeds
     */
    public String longestDupSubstring_set(String s) {
        if (s == null || s.length() < 2) return "";

        int lo = 0;
        int hi = s.length() - 1;

        String duplicate = "";

        while (lo <= hi) {
            int size = lo + (hi - lo) / 2;

            Set<String> patterns = new HashSet<>();

            int hash = 0;

            for (int i = 0; i <= s.length() - size; i++) {
                String current = s.substring(i, i + size);


                if (!patterns.add(current)) {
                    duplicate = current;
                    break;
                }
            }

            if (duplicate.length() < size) hi = size - 1;
            else lo = size + 1;
        }

        return duplicate;
    }

    /*
    // Single-loop Trie, doesn't work for 'bnaaknak' due to n -> [a, ak] satisfies 'nak' (vs 'naak')
    public String longestDupSubstring(String s) {
        if (s == null || s.length() < 2) return "";

        String duplicate = "";
        StringBuilder sb = new StringBuilder();
        int prev = s.charAt(0) - 'a';

        boolean[][] prefix = new boolean[27][28];
        prefix[prev][0] = true;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (prefix[prev][c - 'a' + 1] || prev == c - 'a') {
                sb.append((char) (prev + 'a'));
            } else {
                if (sb.length() > 0) {
                    sb.append((char) (prev + 'a'));
                    if (duplicate.length() < sb.length()) duplicate = sb.toString();
                    sb.setLength(0);
                }

                prefix[prev][c - 'a' + 1] = true;
                prefix[c - 'a'][0] = true;
            }

            prev = c - 'a';
        }

        // handle last element
        if (sb.length() > 0 || prefix[prev][0]) {
            sb.append((char) (prev + 'a'));
            if (duplicate.length() < sb.length()) duplicate = sb.toString();
        }

        return duplicate;
    }
    */
}

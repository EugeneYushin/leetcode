package algo;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {
    /**
     * Sliding window
     * Time complexity: O(l1 + (l2-l1)*26)
     * Space complexity: O(52) = O(1)
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;

        int[] freq1 = new int[26], freq2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (eq(freq1, freq2)) return true;
            freq2[s2.charAt(i) - 'a']--;
            freq2[s2.charAt(i + s1.length()) - 'a']++;
        }

        return eq(freq1, freq2);
    }

    private boolean eq(int[] f1, int[] f2) {
        // O(26)
        for (int i = 0; i < f1.length; i++) {
            if (f1[i] != f2[i]) return false;
        }
        return true;
    }
}

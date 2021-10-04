package algo;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int[] cache = new int[128];

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (cache[s.charAt(j)] > 0) {
                i = Math.max(i, cache[s.charAt(j)]);
            }
            // cache is initialized with all 0s, so +1 is required to not skip the 1st element
            cache[s.charAt(j)] = j + 1;
            length = Math.max(length, j - i + 1);
        }

        return length;
    }
}

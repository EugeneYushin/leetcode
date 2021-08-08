package algo;

import java.util.List;

public class WordBreak {
    /**
     * DP solution.
     * Intuition:
     * For the current char in string, can we find the word in dict which ends with this char?
     * If we can find the word, can we split the string in this place?
     *
     * Time complexity: O(N*M),
     *      N - length of input string
     *      M - length of word dict
     * Space complexity: O(N) to store DP array of booleans
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; // default for bool is false
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (i + 1 >= word.length() // can we look back at all?
                        && s.substring(i - word.length() + 1, i + 1).equals(word)   // can we find the word from the dict?
                        && dp[i - word.length() + 1]) { // does the previous word ends where the current starts?
                    dp[i + 1] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }

    /**
     * Brute-force with recursion
     * Time complexity: O(2^N)
     * Explanation:
     *  https://leetcode.com/problems/word-break/discuss/169383/solved-The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below
     *  https://leetcode.com/problems/word-break/discuss/169383/solved-The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below/452312
     */
    public boolean wordBreak_bruteForce(String s, List<String> wordDict) {
        if (s.length() == 0) return true;

        StringBuilder sb = new StringBuilder(s.length());

        for (Character c : s.toCharArray()) {
            sb.append(c);
            // List can be replaced with Set to achieve O(1) for `contains` calls, though requires extra O(N) space
            if (wordDict.contains(sb.toString()) && wordBreak_bruteForce(s.substring(sb.length()), wordDict)) {
                return true;
            }
        }

        return false;
    }
}

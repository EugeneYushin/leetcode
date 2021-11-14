package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/iterator-for-combination/
 */
class CombinationIterator {
    private List<String> allCombinations = new ArrayList<>();
    private int idx = 0;

    /**
     * Time complexity: O(Cnk), number of combinations
     * Space complexity: O(Cnk), number of combinations
     */
    public CombinationIterator(String characters, int combinationLength) {
        backtrack(characters, "", 0, combinationLength);
    }

    /**
     * Time complexity: O(1)
     */
    public String next() {
        return allCombinations.get(idx++);
    }

    /**
     * Time complexity: O(1)
     */
    public boolean hasNext() {
        return idx < allCombinations.size();
    }

    private void backtrack(String s, String combination, int i, int combinationLength) {
        if (combination.length() == combinationLength) {
            allCombinations.add(combination);
            return;
        }

        for (int j = i; j < s.length(); j++) {
            backtrack(s, combination + s.charAt(j), j + 1, combinationLength);
        }
    }
}

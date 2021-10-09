package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 */
public class Combinations {
    /**
     * Recursive, backtracking solution
     * Time complexity: O(n!/(k!*(n-k)!)
     * Space complexity: O(k), recursion goes deep to k
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            combination.add(i);
            backtrack(result, combination, i + 1, n, k - 1);
            combination.remove(combination.size() - 1); // backtrack
        }
    }
}

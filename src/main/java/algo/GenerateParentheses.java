package algo;

import java.util.*;

public class GenerateParentheses {
    /**
     * https://leetcode.com/problems/generate-parentheses/discuss/10369/Clean-Python-DP-Solution
     * To generate all n-pair parentheses, we can do the following:
     *
     * Generate one pair: ()
     * Generate 0 pair inside, n - 1 afterward: () (...)...
     * Generate 1 pair inside, n - 2 afterward: (()) (...)...
     * ...
     * Generate n - 1 pair inside, 0 afterward: ((...))
     */
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>(n);
        int counter = n;
        while (counter-- >= 0) {
            dp.add(new LinkedList<>());
        }
        dp.set(0, Collections.singletonList(""));

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                List<String> pairs = new LinkedList<>();
                for (String outside : dp.get(i - j - 1)) {
                    for (String inside : dp.get(j)) {
                        pairs.add("(" + inside + ")" + outside);
                    }
                }
                dp.get(i).addAll(pairs);
            }
        }

        return dp.get(n);
    }
}

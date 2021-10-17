package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSum3 {
    /**
     * Memoization with prefix map and backtracking
     * Time complexity: O(N)
     * Space complexity: O(N) for degenerated tree as list, O(logN) for balanced tree
     */
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixes = new HashMap<>();
        prefixes.put(0, 1); // meaning there's already a dummy prefix if node.val == target
        return backtrack(root, 0, targetSum, prefixes);
    }

    private int backtrack(TreeNode head, int currSum, int target, Map<Integer, Integer> prefixes) {
        if (head == null) return 0;

        currSum += head.val;
        // memoization, is there any node in the middle with the path to the current equals target?
        int count = prefixes.getOrDefault(currSum - target, 0);
        prefixes.put(currSum, prefixes.getOrDefault(currSum, 0) + 1);

        count += backtrack(head.left, currSum, target, prefixes) + backtrack(head.right, currSum, target, prefixes);
        prefixes.put(currSum, prefixes.get(currSum) - 1);   // backtrack, bottom-top recursion
        return count;
    }


    /**
     * Time complexity: O(N*logN) vs O(N^2)
     * Space complexity: O(N)
     */
    public int pathSum_dfs(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return dfs_pathFrom(root, targetSum) +
                pathSum_dfs(root.left, targetSum) +
                pathSum_dfs(root.right, targetSum);
    }

    private int dfs_pathFrom(TreeNode head, int target) {
        if (head == null) return 0;
        return (head.val == target ? 1 : 0) +
                dfs_pathFrom(head.left, target - head.val) +
                dfs_pathFrom(head.right, target - head.val);
    }


    private int count;

    /**
     * Time complexity: O(n*(n+1)/2)
     * Space complexity: O(n*(n+1)/2)
     */
    public int pathSum_dfs_nonOptimal(TreeNode root, int targetSum) {
        count = 0;
        dfs_nonOptimal(root, targetSum);
        return count;
    }

    private List<Integer> dfs_nonOptimal(TreeNode head, int target) {
        if (head == null) return Collections.emptyList();

        List<Integer> l = new LinkedList<>();
        if (head.val == target) count++;

        l.add(head.val);
        for (int i : dfs_nonOptimal(head.left, target)) {
            int sum = i + head.val;
            if (sum == target) count++;
            l.add(sum);
        }

        for (int i : dfs_nonOptimal(head.right, target)) {
            int sum = i + head.val;
            if (sum == target) count++;
            l.add(sum);
        }

        return l;
    }
}

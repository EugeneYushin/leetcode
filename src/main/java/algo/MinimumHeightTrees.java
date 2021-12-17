package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class MinimumHeightTrees {
    /**
     * Topological sort
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);

        List<Set<Integer>> links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            links.add(new HashSet<>());
        }

        // adjacent lists
        for (int[] e : edges) {
            links.get(e[0]).add(e[1]);
            links.get(e[1]).add(e[0]);
        }

        // 1st layer of leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (links.get(i).size() == 1) leaves.add(i);
        }

        int numOfNodesLeft = n;
        // there could be at most 2 centroids
        while (numOfNodesLeft > 2) {
            numOfNodesLeft -= leaves.size();

            List<Integer> nextleaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                Integer neighbour = links.get((int) leaf).iterator().next(); // there's always 1 neighbour in leaf
                links.get((int) neighbour).remove(leaf); // remove edge from neigbour to leaf
                if (links.get(neighbour).size() == 1) {
                    nextleaves.add(neighbour);
                }
            }

            leaves = nextleaves;
        }

        return leaves;
    }

    /**
     * TLE, Brute force with memo
     * Time complexity: O(N^2)
     * Space complexity: O(N)
     */
    public List<Integer> findMinHeightTrees_bruteForce(int n, int[][] edges) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            m.get(e[0]).add(e[1]);
            m.get(e[1]).add(e[0]);
        }

        // (from_to, height)
        Map<String, Integer> memo = new HashMap<>();

        int minH = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int height = dfs(i, -1, m, memo);

            if (height > minH) {
                continue;
            } else if (height < minH) {
                minH = height;
                result = new ArrayList<>();
            }

            result.add(i);
        }

        return result;
    }

    private int dfs(int head, int previous, Map<Integer, List<Integer>> links, Map<String, Integer> memo) {
        int h = 0;

        for (int i = 0; i < links.get(head).size(); i++) {
            Integer next = links.get(head).get(i);

            if (next != previous) {
                Integer candidate = memo.getOrDefault(head + " " + next, dfs(next, head, links, memo) + 1);
                memo.putIfAbsent(head + " " + next, candidate);
                h = Math.max(h, candidate);
            }
        }

        return h;
    }
}

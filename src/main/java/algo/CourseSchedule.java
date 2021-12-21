package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    /**
     * Topological sort
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> outputEdges = new HashMap<>();
        Map<Integer, Integer> countOfInputLinks = new HashMap<>();

        for (int[] p : prerequisites) {
            countOfInputLinks.put(p[0], countOfInputLinks.getOrDefault(p[0], 0) + 1);
            countOfInputLinks.putIfAbsent(p[1], 0);

            List<Integer> outEdge = outputEdges.getOrDefault(p[1], new ArrayList<>());
            outEdge.add(p[0]);
            outputEdges.put(p[1], outEdge);
        }

        List<Integer> leaves = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : countOfInputLinks.entrySet()) {
            if (e.getValue() == 0) leaves.add(e.getKey());
        }

        while (!leaves.isEmpty()) {
            List<Integer> newLeaves = new ArrayList<>();

            for (int l : leaves) {
                countOfInputLinks.remove(l);
                if (outputEdges.containsKey(l)) {
                    for (int n : outputEdges.get(l)) {
                        int prev = countOfInputLinks.get(n);
                        if (prev == 1) {
                            newLeaves.add(n);
                        } else {
                            countOfInputLinks.put(n, prev - 1);
                        }
                    }
                }
            }

            leaves = newLeaves;
        }

        return countOfInputLinks.isEmpty();
    }
}

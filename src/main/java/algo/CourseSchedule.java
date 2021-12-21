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
        List<Integer>[] outputEdges = new ArrayList[numCourses];
        int[] countOfInputLinks = new int[numCourses];

        for (int[] p : prerequisites) {
            countOfInputLinks[p[0]]++;
            if (outputEdges[p[1]] == null) {
                outputEdges[p[1]] = new ArrayList<>();
            }

            outputEdges[p[1]].add(p[0]);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < countOfInputLinks.length; i++) {
            if (countOfInputLinks[i] == 0) leaves.add(i);
        }

        int count = 0;
        while (!leaves.isEmpty()) {
            count++;
            int leaf = leaves.poll();
            List<Integer> neighbours = outputEdges[leaf];
            if (neighbours != null) {
                for (int neighbour : neighbours) {
                    if (--countOfInputLinks[neighbour] == 0) leaves.add(neighbour);
                }
            }
        }

        return numCourses == count;
    }
}

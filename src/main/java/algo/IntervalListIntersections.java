package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersections {
    /**
     * Time complexity: O(min(a,b))
     * Space complexity: O(1)
     */
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        int first = 0;
        int second = 0;

        List<int[]> result = new ArrayList<>();

        while (first < a.length && second < b.length) {
            int lo = Math.max(a[first][0], b[second][0]);
            int hi = Math.min(a[first][1], b[second][1]);

            if (lo <= hi) result.add(new int[] {lo, hi});

            if (a[first][1] <= hi) first++;
            if (b[second][1] <= hi) second++;
        }

        return result.toArray(new int[0][]);
    }
}

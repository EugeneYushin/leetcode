package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    /**
     * Time complexity: O(N*logN)
     * Space complexity: O(logN) internally for sorting + O(N) for intermediate result => O(N)
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int left = intervals[0][0];
        int right = intervals[0][1];

        List<int[]> merged = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (right < intervals[i][0]) {
                merged.add(new int[] {left, right});
                left = intervals[i][0];
            }
            right = Math.max(right, intervals[i][1]);
        }
        merged.add(new int[] {left, right});

        return merged.toArray(new int[0][]);
    }
}

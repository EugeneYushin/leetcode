package algo;

import java.util.*;

public class CarPooling {
    /**
     * Time complexity: O(trips)
     * Space complexity: O(trips)
     */
    public boolean carPooling(int[][] trips, int capacity) {
        // sort by `from` chronologically
        Arrays.sort(trips, Comparator.comparingInt(i -> i[1]));

        // sort by `to` for passengers with closer destination to process earlier
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));

        for (int[] trip : trips) {
            while (!q.isEmpty() && trip[1] >= q.peek()[2]) {
                // hop off passengers from previous trips
                capacity += q.poll()[0];
            }

            // hop in passengers for current trip
            capacity -= trip[0];
            if (capacity < 0) return false;

            q.offer(trip);
        }

        return true;
    }

    /**
     * Brute-force optimized
     * Time complexity: O(trips)
     * Space complexity: O(maxTripLength)
     */
    public boolean carPooling_optimized(int[][] trips, int capacity) {
        int[] path = new int[1001];

        // process edges
        for (int[] trip : trips) {
            path[trip[1]] += trip[0];
            path[trip[2]] -= trip[0];
        }

        // reduce in between
        for (int i = 1; i < path.length; i++) {
            path[i] += path[i - 1];
        }

        for (int i : path) {
            if (i > capacity) return false;
        }

        return true;
    }

    /**
     * Time complexity: O(trips*tripsLength)
     * Space complexity: O(maxTripLength)
     */
    public boolean carPooling_bruteForce(int[][] trips, int capacity) {
        int[] path = new int[1001];

        for (int[] trip : trips) {
            for (int i = trip[1]; i < trip[2]; i++) {
                path[i] += trip[0];
            }
        }

        for (int i : path) {
            if (i > capacity) return false;
        }

        return true;
    }
}

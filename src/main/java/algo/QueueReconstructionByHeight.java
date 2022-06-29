package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class QueueReconstructionByHeight {
    /**
     * Time complexity: O(NlogN + N^2) = O(N^2)
     * Space complexity: O(logN) for sorting
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];   // secondary desc: ..., [7,1], [7,0]
            else return o1[0] - o2[0];  // primary asc: ..., [3,x], [4,y]
        });

        for (int i = people.length - 2; i >= 0; i--) {
            if (people[i] == people[i + 1]) {
                // [7,2], [7,1] -> [7,1] [7,2]
                swap(people, i, i + 1);
            } else {
                // [5,3], [7,0]
                move(people, i, people[i][1]);
            }
        }

        return people;
    }

    private void move(int[][] arr, int from, int steps) {
        while (steps-- > 0) {
            swap(arr, from, from + 1);
            from++;
        }
    }

    private void swap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

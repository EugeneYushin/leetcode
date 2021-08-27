package algo;

import java.util.LinkedList;
import java.util.Queue;

public class RotateImage {
    /**
     * Time complexity: O(N^2)
     * Space complexity: O(N)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2) return;

        int mid = ((n & 1) == 0) ? n / 2 + 1 : n / 2;
        int step = 0;
        Queue<Integer> q = new LinkedList<>();

        while (step < mid) {
            for (int i = step; i < n - step - 1; i++) {
                q.add(matrix[i][n - step - 1]);
                matrix[i][n - step - 1] = matrix[step][i];
            }

            for (int i = step; i < n - step - 1; i++) {
                q.add(matrix[n - step - 1][n - i - 1]);
                matrix[n - step - 1][n - i - 1] = q.poll();
            }

            for (int i = n - step - 1; i > step; i--) {
                q.add(matrix[i][step]);
                matrix[i][step] = q.poll();
            }

            for (int i = step; i < n - step - 1; i++) {
                matrix[step][i] = q.poll();
            }

            step++;
        }
    }
}

package algo;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    /**
     * BFS solution
     * Explanation: https://leetcode.com/problems/surrounded-regions/discuss/1552669/Java-BFSQueue-from-borders-to-center
     * Time complexity: O(n*m)
     * Space complexity: O(n+m)
     */
    public void solve(char[][] board) {
        if (board.length == 1 || board[0].length == 1) return;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') q.add(new int[] {i, 0});
            if (board[i][board[0].length - 1] == 'O') q.add(new int[] {i, board[0].length - 1});
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') q.add(new int[] {0, i});
            if (board[board.length - 1][i] == 'O') q.add(new int[] {board.length - 1, i});
        }

        while (!q.isEmpty()) {
            int[] yx = q.poll();
            int y = yx[0], x = yx[1];

            board[y][x] = 'V';
            if (y > 0 && board[y - 1][x] == 'O') q.add(new int[] {y - 1, x});
            if (y < board.length - 1 && board[y + 1][x] == 'O') q.add(new int[] {y + 1, x});

            if (x > 0 && board[y][x - 1] == 'O') q.add(new int[] {y, x - 1});
            if (x < board[0].length - 1 && board[y][x + 1] == 'O') q.add(new int[] {y, x + 1});
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = board[r][c] == 'V' ? 'O' : 'X';
            }
        }
    }
}

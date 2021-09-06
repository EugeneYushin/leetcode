package algo;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    /**
     * Depth-first-search based solution
     * Time complexity: O(M*N*4^s), M - num of rows, N - num of cols, s - length of the word
     * Space complexity: O(4^s)
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty() ||
                board == null || board.length == 0 || board[0].length == 0 ||
                board.length * board[0].length < word.length()
        ) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int pos) {
        if (pos == word.length()) return true;
        if (row > board.length - 1 || row < 0 ||
                col > board[0].length - 1 || col < 0 ||
                board[row][col] != word.charAt(pos)) return false;

        board[row][col] = '-'; // XOR 256 can be used as well: https://leetcode.com/problems/word-search/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space./216550

        boolean result = dfs(board, word, row + 1, col, pos + 1) ||
                dfs(board, word, row - 1, col, pos + 1) ||
                dfs(board, word, row, col + 1, pos + 1) ||
                dfs(board, word, row, col - 1, pos + 1);

        board[row][col] = word.charAt(pos);

        return result;
    }
}

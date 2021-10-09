package algo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearch2 {
    class Node {
        boolean isWord;
        Node[] next = new Node[26];

        void insert(String word) {
            Node head = this;
            for (int i = 0; i < word.length(); i++) {
                if (head.next[word.charAt(i) - 'a'] == null) {
                    Node n = new Node();
                    head.next[word.charAt(i) - 'a'] = n;
                    head = n;
                } else {
                    head = head.next[word.charAt(i) - 'a'];
                }
            }
            head.isWord = true;
        }
    }

    /**
     * DFS + trie
     * Time complexity: O(r*c*lmax), lmax - length of the longest word
     * Space complexity: O(L), L = (sum of words lengths) - (sum of lengths of common prefixes)
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        Node root = new Node();
        // add words to prefix tree (trie)
        for (String w : words) {
            root.insert(w);
        }

        // iterate over each char and use DFS to find matches
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, new StringBuilder(), result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int row, int col, Node node, StringBuilder sb, List<String> result) {
        if (row < 0 || col < 0 || row == board.length || col == board[0].length ||
                board[row][col] > 255 ||
                node.next[board[row][col] - 'a'] == null) {
            return;
        }

        Node nextNode = node.next[board[row][col] - 'a'];
        sb.append(board[row][col]);

        // be sure we won't re-use this char in the following recursive calls
        board[row][col] ^= 256; // XOR

        if (nextNode.isWord) {
            nextNode.isWord = false;
            result.add(sb.toString());
        }

        dfs(board, row + 1, col, nextNode, sb, result);
        dfs(board, row - 1, col, nextNode, sb, result);
        dfs(board, row, col + 1, nextNode, sb, result);
        dfs(board, row, col - 1, nextNode, sb, result);

        sb.deleteCharAt(sb.length() - 1);
        board[row][col] ^= 256;
    }
}

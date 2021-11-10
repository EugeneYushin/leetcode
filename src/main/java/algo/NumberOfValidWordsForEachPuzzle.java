package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/
 */
public class NumberOfValidWordsForEachPuzzle {
    static class Trie {
        private TrieNode root = new TrieNode('-');

        public void add(String word) {
            TrieNode head = root;
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';

                if (head.children[charIndex] == null) {
                    head.children[charIndex] = new TrieNode(word.charAt(i));
                }

                head = head.children[charIndex];
            }
            head.numOfWordsEndingHere++;
        }
    }

    static class TrieNode {
        char val;
        int numOfWordsEndingHere = 0;   // this is necessary to count duplicated prefixes
        TrieNode[] children = new TrieNode[26];

        public TrieNode(char val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "{" +
                    "val=" + val +
                    ", numOfWordsEndingHere=" + numOfWordsEndingHere +
                    '}';
        }
    }

    private int dfs(TrieNode node, String puzzle, boolean seen) {
        int count = seen ? node.numOfWordsEndingHere : 0;
        for (int i = 0; i < puzzle.length(); i++) {
            TrieNode next = node.children[puzzle.charAt(i) - 'a'];
            if (next != null) {
                count += dfs(next, puzzle, seen || next.val == puzzle.charAt(0));
            }
        }

        return count;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Trie trie = new Trie();

        // sort and remove duplicate letters from string
        for (String w : words) {
            char[] chars = w.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            sb.append(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != chars[i - 1]) sb.append(chars[i]);
            }

            if (sb.length() <= 7) trie.add(sb.toString());
        }

        List<Integer> result = new ArrayList<>(puzzles.length);
        for (String p : puzzles) {
            result.add(dfs(trie.root, p, false));
        }

        return result;
    }

    /**
     * Brute-force solution
     * Time complexity: O(Puzzles*(PlettersMax+Words*(WLengthMax))) = O(Puzzles*Words*WLengthMax)
     * Space complexity: O(PlettersMax)
     */
    public List<Integer> findNumOfValidWords_bruteForce(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>(puzzles.length);

        for (String p : puzzles) {
            char first = p.charAt(0);
            Set<Character> letters = new HashSet<>(p.length());
            for (int i = 0; i < p.length(); i++) letters.add(p.charAt(i));

            int count = 0;
            iterateWords:
            for (String w : words) {
                if (w.indexOf(first) == -1) continue;
                for (int i = 0; i < w.length(); i++) {
                    if (!letters.contains(w.charAt(i))) continue iterateWords;
                }
                count++;
            }

            result.add(count);
        }

        return result;
    }
}

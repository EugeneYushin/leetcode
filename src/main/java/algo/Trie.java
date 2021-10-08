package algo;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
class Trie {
    class TrieNode {
        boolean isWord = false;
        TrieNode[] next = new TrieNode[26];

        @Override
        public String toString() {
            char[] chars = new char[next.length];
            for (int i = 0; i < next.length; i++) {
                if (next[i] != null) chars[i] = (char)('a' + i);
            }

            return "TrieNode{" +
                    "isWord=" + isWord +
                    ", next=" + Arrays.toString(chars) +
                    '}';
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode head = root;
        for (int i = 0; i < word.length(); i++) {
            if (head.next[word.charAt(i) - 'a'] == null) {
                TrieNode nextNode = new TrieNode();
                head.next[word.charAt(i) - 'a'] = nextNode;
                head = nextNode;
            } else {
                head = head.next[word.charAt(i) - 'a'];
            }
        }

        head.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode head = root;
        for (int i = 0; i < word.length(); i++) {
            if (head.next == null || head.next[word.charAt(i) - 'a'] == null) return false;
            else head = head.next[word.charAt(i) - 'a'];
        }

        return head.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode head = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (head.next == null || head.next[prefix.charAt(i) - 'a'] == null) return false;
            else head = head.next[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

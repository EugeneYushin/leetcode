package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse Trie
 */
class StreamChecker {
    class Node {
        Node[] next = new Node[26];
        boolean isWord;

        public void add(String s) {
            Node current = this;

            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (current.next[c - 'a'] == null) {
                    current.next[c - 'a'] = new Node();
                }
                current = current.next[c - 'a'];
            }

            current.isWord = true;
        }
    }

    int maxLength;
    Node root;
    StringBuilder sb;

    /**
     * Time complexity: O(N*Lmax)
     * Space complexity: O(N*Lmax)
     */
    public StreamChecker(String[] words) {
        root = new Node();
        maxLength = 0;
        for (String w : words) {
            root.add(w);
            maxLength = Math.max(maxLength, w.length());
        }

        sb = new StringBuilder(maxLength);
    }

    /**
     * Time complexity: O(Lmax)
     * Space complexity: O(1)
     */
    public boolean query(char letter) {
        if (sb.length() == maxLength) {
            sb.deleteCharAt(0);
        }

        sb.append(letter);
        Node head = root;

        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (head.next[c - 'a'] == null) break;
            if (head.next[c - 'a'].isWord) return true;
            head = head.next[c - 'a'];
        }

        return false;
    }
}


class StreamChecker_WithCandidates {
    class Node {
        Node[] next;
        boolean isWord;

        public Node() {
            this.next = new Node[26];
            this.isWord = false;
        }

        public void add(String s) {
            Node current = this;
            Node next = null;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (current.next[c - 'a'] == null) {
                    next = new Node();
                    current.next[c - 'a'] = next;
                } else {
                    next = current.next[c - 'a'];
                }

                current = next;
            }

            next.isWord = true;
        }
    }

    Node root;
    List<Node> candidates;

    public StreamChecker_WithCandidates(String[] words) {
        this.root = new Node();
        for (String w : words) {
            this.root.add(w);
        }
        this.candidates = new ArrayList<>();
        candidates.add(root);
    }

    public boolean query(char letter) {
        boolean seen = false;
        List<Integer> toRemove = new ArrayList<>();

        for (int i = 0; i < candidates.size(); i++) {
            Node current = candidates.get(i);
            Node next = current.next[letter - 'a'];

            if (next == null) {
                toRemove.add(i);
            } else {
                candidates.set(i, current.next[letter - 'a']);
                if (next.isWord) seen = true;
            }
        }

        for (int i = 0; i < toRemove.size(); i++) {
            candidates.remove(toRemove.get(i) - i);
        }

        if (root.next[letter - 'a'] != null) {
            candidates.add(root.next[letter - 'a']);
            if (root.next[letter - 'a'].isWord) seen = true;
        }

        return seen;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */

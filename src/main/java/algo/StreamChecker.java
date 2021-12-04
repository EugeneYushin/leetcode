package algo;

import java.util.ArrayList;
import java.util.List;

class StreamChecker {
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

    public StreamChecker(String[] words) {
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

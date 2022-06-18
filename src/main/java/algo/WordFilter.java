package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/prefix-and-suffix-search/submissions/
 */
class WordFilter {
    class Trie {
        Trie[] children = new Trie[26];
        boolean isWord = false;

        public void add(String w) {
            Trie curr = this;

            for (int i = 0; i < w.length(); i++) {
                int pos = w.charAt(i) - 'a';
                Trie next = curr.children[pos] == null ? new Trie() : curr.children[pos];
                curr.children[pos] = next;
                curr = next;
            }
            curr.isWord = true;
        }

        public Trie find(String prefix) {
            Trie curr = this;

            for (int i = 0; i < prefix.length(); i++) {
                int pos = prefix.charAt(i) - 'a';
                if (curr.children[pos] == null) return null;

                curr = curr.children[pos];
            }

            return curr;
        }

        @Override
        public String toString() {
            char[] chars = new char[children.length];
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null) chars[i] = (char) ('a' + i);
            }

            return "Trie{" +
                    "isWord=" + isWord +
                    ", next=" + Arrays.toString(chars) +
                    '}';
        }
    }

    private Map<String, Integer> wordToIndex;
    private Trie prefixHead;
    private Trie suffixHead;


    public WordFilter(String[] words) {
        wordToIndex = new HashMap<>();
        prefixHead = new Trie();
        suffixHead = new Trie();

        for (int i = 0; i < words.length; i++) {
            String w = words[i];

            wordToIndex.put(w, i);
            prefixHead.add(w);
            suffixHead.add(new StringBuilder(w).reverse().toString());
        }
    }

    public int f(String prefix, String suffix) {
        // prefix
        Trie prefixNode = prefixHead.find(prefix);
        if (prefixNode == null) return -1;

        Set<String> prefixWords = new HashSet<>();
        StringBuilder sb = new StringBuilder(prefix);

        dfs(prefixNode, sb, prefixWords, false);

        // System.out.println(prefixWords);

        // suffix
        sb = new StringBuilder(suffix).reverse();
        Trie suffixNode = suffixHead.find(sb.toString());
        if (suffixNode == null) return -1;

        Set<String> suffixWords = new HashSet<>();

        dfs(suffixNode, sb, suffixWords, true);

        // System.out.println(suffixWords);

        // intersect
        int index = -1;

        prefixWords.retainAll(suffixWords);

        for (String w : prefixWords) {
            index = Math.max(index, wordToIndex.getOrDefault(w, -1));
        }

        return index;
    }


    private void dfs(Trie node, StringBuilder sb, Set<String> found, boolean reverse) {
        if (node == null) return;
        if (node.isWord) {
            sb = reverse ? new StringBuilder(sb).reverse() : sb;    // reverse() mutates original object
            found.add(sb.toString());
        }

        for (int i = 0; i < node.children.length; i++) {
            sb.append((char) ('a' + i));
            dfs(node.children[i], sb, found, reverse);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */

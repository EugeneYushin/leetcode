package algo;

import java.util.*;

public class ShortEncodingOfWords {

    // suffix trie
    class Trie {
        Trie[] next = new Trie[26];
        boolean isWord = false;

        public void add(String word) {
            Trie n = this;

            for (int i = word.length() - 1; i >= 0; i--) {
                if (n.next[word.charAt(i) - 'a'] == null) {
                    n.next[word.charAt(i) - 'a'] = new Trie();
                }
                n = n.next[word.charAt(i) - 'a'];
            }

            n.isWord = true;
        }

        public boolean contains(String word) {
            Trie n = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (n.next[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                n = n.next[word.charAt(i) - 'a'];
            }

            return n != null;
        }

        @Override
        public String toString() {
            char[] chars = new char[next.length];
            for (int i = 0; i < next.length; i++) {
                if (next[i] != null) chars[i] = (char) ('a' + i);
            }

            return "Trie{" +
                    "isWord=" + isWord +
                    ", next=" + Arrays.toString(chars) +
                    '}';
        }
    }

    /**
     * Sorting + Suffix Trie
     * Time complexity: O(N*K)
     * Space complexity: O(26*K) = O(K)
     *
     *  N - number of words
     *  K - max length of word
     */
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());  // desc

        int res = 0;
        Trie t = new Trie();

        for (String w : words) {
            if (!t.contains(w)) {
                t.add(w);
                res += w.length() + 1;
            }
        }

        return res;
    }


    /**
     * Sorting + Set
     * Time complexity: O(K*N^2)
     * Space complexity: O(N*K)
     *
     *  N - number of words
     *  K - max length of word
     */
    public int minimumLengthEncoding_set(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());  // desc

        Set<String> longWords = new HashSet<>();
        int res = 0;

        for (String w : words) {
            if (longWords.contains(w)) continue;

            boolean isSuffix = false;

            for (String lw : longWords) {
                if (lw.endsWith(w)) {
                    isSuffix = true;
                    break;
                }
            }

            if (!isSuffix) {
                longWords.add(w);
                res += w.length() + 1;
            }
        }

        return res;
    }
}

package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {
    /**
     * Max heap solution
     * Time complexity: O(N*logM) = O(N) because M ~= 256, M - cardinality
     * Space complexity: O(~256) = O(1)
     */
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt(o -> -o[1]));
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            maxHeap.add(new int[]{e.getKey(), e.getValue()});
        }

        StringBuilder sb = new StringBuilder(s.length());

        while (!maxHeap.isEmpty()) {
            int[] f = maxHeap.poll();
            while (f[1]-- > 0) sb.append((char) f[0]);
        }

        return sb.toString();
    }

    /**
     * Sort based solution
     * Time complexity: O(N)
     * Space complexity: O(~256) = O(1)
     */
    public String frequencySort_sortBased(String s) {
        // (count, int value of char)
        int[][] counts = new int['z' - '0' + 1][2];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - '0'][0]++;
            counts[s.charAt(i) - '0'][1] = s.charAt(i);
        }

        // sort by count in descending order
        Arrays.sort(counts, Comparator.comparingInt(o -> -o[0]));

        StringBuilder sb = new StringBuilder(s.length());

        for (int[] i : counts) {
            while (i[0]-- > 0) sb.append((char) i[1]);
        }

        return sb.toString();
    }
}

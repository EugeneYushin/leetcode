package algo;

import java.util.PriorityQueue;

public class LongestHappyString {
    /**
     * Time complexity: O(a+b+c), heap max length is 3, for each iteration heap operations take O(log3) => O(1)
     * Space complexity: O(1), max heap has max length is 3
     */
    public String longestDiverseString(int a, int b, int c) {
        // max heap
        PriorityQueue<Tuple2<Integer, Character>> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.first, o1.first));
        if (a > 0) q.add(new Tuple2<>(a, 'a'));
        if (b > 0) q.add(new Tuple2<>(b, 'b'));
        if (c > 0) q.add(new Tuple2<>(c, 'c'));

        StringBuilder sb = new StringBuilder(a + b + c);

        while (!q.isEmpty()) {
            Tuple2<Integer, Character> head = q.poll();
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == head.second && sb.charAt(sb.length() - 2) == head.second) {
                // adding char at head will break the happiness
                if (q.isEmpty()) break;

                Tuple2<Integer, Character> next = q.poll();
                sb.append(next.second);
                next.first -= 1;
                if (next.first > 0) {
                    q.add(next);
                }
                q.add(head);
            } else {
                // we can easily add char at head
                sb.append(head.second);
                head.first -= 1;
                if (head.first > 0) {
                    q.add(head);
                }
            }
        }

        return sb.toString();
    }
}

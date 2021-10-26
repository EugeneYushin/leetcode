package algo;

/**
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {
    class Node {
        int min;
        Node next;
        int val;

        public Node(int min) {
            this.min = min;
        }

        public Node(int min, Node next, int val) {
            this.min = min;
            this.next = next;
            this.val = val;
        }
    }

    private Node head;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, null, val);
        } else {
            head = new Node(Math.min(val, head.min), head, val);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

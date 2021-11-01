package algo;

import java.util.Stack;

/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/submissions/
 */
public class FlattenMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public Node flatten(Node head) {
        Node pointer = head;

        while (pointer != null) {
            if (pointer.child == null) {
                pointer = pointer.next;
                continue;
            }

            // there's a child
            // rewind the tail of the child
            Node child = pointer.child;
            while (child.next != null) child = child.next;

            child.next = pointer.next;
            if (pointer.next != null) pointer.next.prev = child;

            pointer.next = pointer.child;
            pointer.child.prev = pointer;
            pointer.child = null;
            pointer = pointer.next;
        }

        return head;
    }

    /**
     * DFS solution
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public Node flatten_stack(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node dummy = new Node();
        Node pointer = dummy;

        while (!stack.empty()) {
            Node node = stack.pop();
            if (node.next != null) stack.push(node.next);
            if (node.child != null) {
                stack.push(node.child);
                node.child = null;
            }

            pointer.next = node;
            node.prev = pointer;
            pointer = pointer.next;
        }

        Node root = dummy.next;
        root.prev = null;
        return root;
    }
}

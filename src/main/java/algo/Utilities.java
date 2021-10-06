package algo;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(val).append(",");

        ListNode p = this;
        while (p.next != null) {
            p = p.next;
            builder.append(p.val).append(",");
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    public static ListNode fromArray(int[] arr) {
        ListNode head = new ListNode();
        ListNode curr = head;
        for (int i : arr) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return arr.length == 0 ? head : head.next;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode node = (TreeNode) o;
        return val == node.val &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(this);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                builder.append("\n");
                if (!q.isEmpty()) q.add(null);
                continue;
            }

            builder.append(node.val).append(" ");

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }

        return builder.toString();
    }
}

/**
 * TreeNode with next pointer
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right) &&
                Objects.equals(next, node.next);
    }
}

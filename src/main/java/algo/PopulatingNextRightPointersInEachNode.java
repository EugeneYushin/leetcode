package algo;

import java.util.LinkedList;
import java.util.Queue;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

public class PopulatingNextRightPointersInEachNode {
    /**
     * DSF pre-order, Take and advantage of already discovered node.next value to set node.right.next
     * Time complexity: O(N)
     * Space complexity: O(logN) for recursive stack
     */
    public Node connect(Node root) {
        if (root == null) return null;

        if (root.left != null) root.left.next = root.right;
        if (root.right != null && root.next != null) root.right.next = root.next.left;

        connect(root.left);
        connect(root.right);

        return root;
    }

    /**
     * BFS
     * Time complexity: O(N)
     * Space complexity: O(N/2)
     */
    public Node connect_bfs(Node root) {
        if (root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            Node current = q.poll();
            Node next = q.peek();

            current.next = next;
            if (current.left != null) q.offer(current.left);
            if (current.right != null) q.offer(current.right);

            if (next == null) {
                q.poll();       // remove current layer indicator
                if (!q.isEmpty()) q.offer(null);  // put new layer indicator to the end
            }
        }

        return root;
    }
}

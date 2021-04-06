package demo.leetcode.q116;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        Node prev = null;
        int len = queue.size();
        int idx = 0;

        for (; idx < len; ) {
            Node curr = queue.poll();
            if (prev == null) {
                prev = curr;
            } else {
                prev.next = curr;
                prev = curr;
            }

            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);

            if (idx == len - 1) {
                prev = null;
                idx = 0;
                len = queue.size();
            } else ++idx;
        }

        return root;
    }

}

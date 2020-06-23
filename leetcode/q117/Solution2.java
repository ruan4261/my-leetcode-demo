package com.ruan.alg.leetcode.leetcode.q117;

public class Solution2 {

    public Node connect(Node root) {
        Node node = root;
        while (node != null) {
            Node dummy = new Node(-1), flag = dummy;

            while (node != null) {
                if (node.left != null) dummy = dummy.next = node.left;
                if (node.right != null) dummy = dummy.next = node.right;
                node = node.next;
            }

            node = flag.next;
        }
        return root;
    }

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

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}

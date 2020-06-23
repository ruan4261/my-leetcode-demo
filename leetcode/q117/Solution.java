package com.ruan.alg.leetcode.leetcode.q117;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * <p>
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public Node connect(Node root) {
        if (root == null) return null;

        Node parent = root;
        while (true) {// 该层拥有next，迭代树高度，parent始终为该层最左侧节点

            // 通过next迭代该层所有节点，对子节点赋予next
            Node scroll = parent;
            while (scroll != null && scroll.left == null && scroll.right == null) scroll = scroll.next;
            if (scroll == null) break;

            Node leftSide = scroll.left == null ? scroll.right : scroll.left;
            Node curr = leftSide;
            Node next = null;

            while (curr != null) {// 要被赋予next的对象
                while (next == null) {
                    next = (curr == scroll.right) ? null : scroll.right;
                    if (next == null) {
                        if (scroll.next == null) break;
                        scroll = scroll.next;
                        next = scroll.left;
                    }
                }
                curr.next = next;
                curr = next;
                next = null;
            }


            parent = leftSide;
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

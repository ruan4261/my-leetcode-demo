package com.ruan.alg.leetcode.leetcode.q572;

public class Solution2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        tCount = calcTCount(t);
        calcCount(s, t);
        return isFoundSame;
    }

    // 计算单棵二叉树的节点个数
    private int calcTCount(TreeNode root) {
        return root == null ? 0 : calcTCount(root.left) + calcTCount(root.right) + 1;
    }

    // 判断两棵二叉树是否相等
    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2 == null;
        if (root2 == null) return false;
        return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    private boolean isFoundSame = false;
    private int tCount;

    // 递归计算二叉树s每棵子树的节点数，并同时寻找是否有子树与t相等
    private int calcCount(TreeNode root, TreeNode t) {
        if (isFoundSame) return 0;

        if (root == null) return 0;

        int count = calcCount(root.left, t) + calcCount(root.right, t) + 1;
        if (isFoundSame) return 0;
        if (count == tCount && isSame(root, t)) {
            isFoundSame = true;
            return 0;
        }
        return count;
    }

}

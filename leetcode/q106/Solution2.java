package com.ruan.alg.leetcode.leetcode.q106;

public class Solution2 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) return null;
        return buildSubTree(inorder, postorder, 0, len - 1, len - 1);
    }

    private TreeNode buildSubTree(int[] inorder, int[] postorder, int i, int j, int k) {
        if (i > j) return null;
        TreeNode node = new TreeNode(postorder[k]);
        if (i == j) return node;
        for (int l = j; ; l--) {
            if (inorder[l] == postorder[k]) {
                node.left = buildSubTree(inorder, postorder, i, l - 1, k + l - j - 1);
                node.right = buildSubTree(inorder, postorder, l + 1, j, k - 1);
                break;
            }
        }
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

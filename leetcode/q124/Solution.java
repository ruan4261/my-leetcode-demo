package com.ruan.alg.leetcode.leetcode.q124;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /* solution */

    private int ans = Integer.MIN_VALUE;

    /**
     * 这种题目算hard就离谱
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        subTreeLongestPath(root);
        return ans;
    }

    private int subTreeLongestPath(TreeNode node) {
        if (node == null) return 0;
        int leftLongest = subTreeLongestPath(node.left);
        int rightLongest = subTreeLongestPath(node.right);
        if (leftLongest < 0) leftLongest = 0;
        if (rightLongest < 0) rightLongest = 0;

        int longestOfIncludeCurrentNode = node.val + leftLongest + rightLongest;
        if (longestOfIncludeCurrentNode > ans) ans = longestOfIncludeCurrentNode;
        return Math.max(leftLongest, rightLongest) + node.val;
    }
}

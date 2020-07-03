package demo.leetcode.q105;

/**
 *         3
 *        / \
 *       9  20
 *      /  /  \
 *     8  15   7
 *    / \
 *   5  10
 *  /
 * 4
 *
 * preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
 * inorder = [4, 5, 8, 10, 9, 3, 15, 20, 7]
 */
public class Solution2 {

    private int pre = 0, in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursive(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode recursive(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        int curVal = preorder[pre++];
        TreeNode cur = new TreeNode(curVal);
        cur.left = recursive(preorder, inorder, curVal);
        cur.right = recursive(preorder, inorder, stop);
        return cur;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

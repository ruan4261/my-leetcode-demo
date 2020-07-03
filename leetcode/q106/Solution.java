package demo.leetcode.q106;

import java.util.Arrays;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) return null;
        if (len == 1) return new TreeNode(inorder[0]);
        return buildSubTree(inorder, 0, len, postorder, 0, len);
    }

    private TreeNode buildSubTree(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        int len = inEnd - inBegin;
        if (len <= 0) return null;
        TreeNode root = new TreeNode(postorder[postEnd - 1]);
        for (int i = inBegin; i < inEnd; i++) {
            if (inorder[i] == root.val) {
                int offset = i - inBegin;
                root.left = buildSubTree(inorder, inBegin, i, postorder, postBegin, postBegin + offset);
                root.right = buildSubTree(inorder, i + 1, inEnd, postorder, postBegin + offset, postEnd - 1);
                break;
            }
        }
        return root;
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

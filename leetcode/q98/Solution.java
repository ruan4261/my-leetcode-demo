package demo.leetcode.q98;

/**
 * 98. 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
class Solution {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        /*if (root.left != null) {
            if (root.left.val >= root.val) return false;
            if (!verifyOnlyMax(root.left, root.val)) return false;
        }
        if (root.right != null) {
            if (root.right.val <= root.val) return false;
            if (!verifyOnlyMin(root.right, root.val)) return false;
        }*/
        if (root.left != null) {
            if (root.left.val >= root.val) {
                return false;
            }
            if (!verify(root.left, null, root.val)) return false;
        }
        if (root.right != null) {
            if (root.right.val <= root.val) {
                return false;
            }
            if (!verify(root.right, root.val, null)) return false;
        }
        return true;
    }

    /**
     * 独立可运行
     *
     * @param treeNode
     * @param min
     * @param max
     * @return
     */
    public boolean verify(TreeNode treeNode, Integer min, Integer max) {
        if (treeNode.left != null) {
            if (treeNode.left.val >= treeNode.val || (min != null && treeNode.left.val <= min))
                return false;
            if (!verify(treeNode.left, min, Integer.valueOf(treeNode.val))) return false;
        }
        if (treeNode.right != null) {
            if (treeNode.right.val <= treeNode.val || (max != null && treeNode.right.val >= max))
                return false;
            if (!verify(treeNode.right, Integer.valueOf(treeNode.val), max)) return false;
        }
        return true;
    }

    /**
     * 验证树区间
     *
     * @param treeNode
     * @param min      区间左极限
     * @param max      区间右极限
     * @return
     */
    public boolean verify(TreeNode treeNode, int min, int max) {
        if (treeNode.left != null) {
            if (treeNode.left.val >= treeNode.val || treeNode.left.val <= min)
                return false;
            if (!verify(treeNode.left, min, treeNode.val)) return false;
        }
        if (treeNode.right != null) {
            if (treeNode.right.val <= treeNode.val || treeNode.right.val >= max)
                return false;
            if (!verify(treeNode.right, treeNode.val, max)) return false;
        }
        return true;
    }

    /**
     * 其实是重载
     * 无右区间限制
     *
     * @param treeNode
     * @param min
     * @return
     */
    public boolean verifyOnlyMin(TreeNode treeNode, int min) {
        if (treeNode.left != null) {
            if (treeNode.left.val >= treeNode.val || treeNode.left.val <= min)
                return false;
            if (!verify(treeNode.left, min, treeNode.val)) return false;
        }
        if (treeNode.right != null) {
            if (treeNode.right.val <= treeNode.val)
                return false;
            if (!verifyOnlyMin(treeNode.right, treeNode.val)) return false;
        }
        return true;
    }

    /**
     * 其实是重载
     * 无左区间限制
     *
     * @param treeNode
     * @param max
     * @return
     */
    public boolean verifyOnlyMax(TreeNode treeNode, int max) {
        if (treeNode.left != null) {
            if (treeNode.left.val >= treeNode.val)
                return false;
            if (!verifyOnlyMax(treeNode.left, treeNode.val)) return false;
        }
        if (treeNode.right != null) {
            if (treeNode.right.val <= treeNode.val || treeNode.right.val >= max)
                return false;
            if (!verify(treeNode.right, treeNode.val, max)) return false;
        }
        return true;
    }
}
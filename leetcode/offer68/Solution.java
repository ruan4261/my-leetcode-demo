package demo.leetcode.offer68;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        dfs(root, p, q, null);
        return ans;
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q, TreeNode find) {
        if (node == null) return null;
        if (node == p || node == q) {
            if (find != null) {
                ans = find;
                return null;
            }

            dfs(node.left, p, q, node);
            if (ans != null) return null;
            dfs(node.right, p, q, node);
            if (ans != null) return null;
            return node;
        } else {
            TreeNode l = dfs(node.left, p, q, find);
            if (ans != null) return null;
            if (l == null) return dfs(node.right, p, q, find);

            TreeNode r = dfs(node.right, p, q, find);
            if (ans != null) return null;
            if (r != null) {
                ans = node;
                return null;
            }
            return l;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

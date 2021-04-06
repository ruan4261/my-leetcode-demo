package demo.leetcode.q1028;

/**
 * 1028. 从先序遍历还原二叉树
 * <p>
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * <p>
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * <p>
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * <p>
 * 给出遍历输出 S，还原树并返回其根节点 root。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *  
 * <p>
 * 提示：
 * <p>
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
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


    private char[] carr;

    private int stop;

    private int len;

    private int idx = 0;

    public TreeNode recoverFromPreorder(String S) {
        carr = S.toCharArray();
        len = carr.length;
        int s = S.indexOf('-');
        if (s == -1) return new TreeNode(Integer.parseInt(S));
        idx = s + 1;
        TreeNode root = new TreeNode(Integer.parseInt(S.substring(0, s)));
        helper(root, 1);
        return root;
    }

    private void helper(TreeNode node, int floor) {
        Integer n = null;
        int fc = 0;
        while (idx < len) {
            char a = carr[idx];

            // char of current index is '-'
            if (a == '-') {
                if (n != null) {
                    TreeNode child = new TreeNode(n);
                    if (node.left != null) node.right = child;
                    else node.left = child;
                    n = null;
                }
                fc = fc + 1;
                idx = idx + 1;
                continue;
            }

            if (len - 1 == idx) {
                stop = 0;
                TreeNode child;
                if (n == null) {
                    n = a - '0';
                    child = new TreeNode(a - '0');
                } else {
                    n = n * 10 + (a - '0');
                    child = new TreeNode(n);
                }

                if (fc == 0 || fc == floor) {
                    if (node.left != null) node.right = child;
                    else node.left = child;
                    return;
                }
                if (fc > floor) {
                    // last number is subtree node of this floor
                    if (node.right != null) {
                        // is right subtree node
                        if (node.right.left != null) node.right.right = child;
                        else node.right.left = child;
                    } else {
                        // is left subtree node
                        if (node.left.left != null) node.left.right = child;
                        else node.left.left = child;
                    }
                    return;
                } else {
                    // last number is uncle node of this floor
                    stop = fc;
                    if (n == 0) return;
                    int i = -1;
                    while (n != 0) {
                        n = n / 10;
                        i = i + 1;
                    }
                    idx = idx - i;
                    return;
                }
            }

            // is not '-', judge floor
            if (fc != 0) {
                if (fc < floor) {
                    stop = fc;
                    return;
                } else if (fc > floor) {
                    if (node.right != null) helper(node.right, fc);
                    else helper(node.left, fc);
                    if (stop == floor) {
                        n = null;
                        fc = 0;
                        stop = 0;
                        continue;
                    }
                    if (stop < floor) return;
                }
                fc = 0;
                n = null;
            }

            if (n == null) {
                n = a - '0';
            } else {
                n = n * 10 + (a - '0');
            }
            idx = idx + 1;
        }
    }

}

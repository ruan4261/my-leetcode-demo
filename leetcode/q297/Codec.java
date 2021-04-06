package demo.leetcode.q297;

import java.util.*;

/**
 * 297. 二叉树的序列化与反序列化
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Codec {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "n";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("n,");
                continue;
            }
            sb.append(node.val).append(',');
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();
        char[] chars = data.toCharArray();
        char[] temp = new char[10];
        int idx = 0;
        int tidx = 0;
        for (char c : chars) {
            if (c == ',') {
                idx = idx + 1;
                if (temp[0] == 'n') {
                    if ((idx & 1) == 1) {
                        if (!queue.isEmpty()) queue.poll();
                    }
                    temp[0] = 0;
                    continue;
                }
                int val = 0;
                boolean f = false;
                for (char value : temp) {
                    if (value == '-') {
                        f = true;
                        continue;
                    }
                    if (value == 0) break;
                    val = val * 10 + (value - '0');
                }
                Arrays.fill(temp, (char) 0);
                TreeNode node = new TreeNode(f ? -val : val);
                if (root == null) root = node;
                if (!queue.isEmpty()) {
                    TreeNode parent;
                    if ((idx & 1) == 1) {
                        parent = queue.poll();
                        parent.right = node;
                    } else {
                        parent = queue.peek();
                        parent.left = node;
                    }
                }
                queue.add(node);
                tidx = 0;
                continue;
            }
            temp[tidx] = c;
            tidx = tidx + 1;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
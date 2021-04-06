package demo.leetcode.q297;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 创建StringBuilder是大开销...
 */
public class Codec2 {

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
        encodeHelper(sb, root);
        return sb.toString();
        //return String.valueOf(root.val) + ',' + serialize(root.left) + ',' + serialize(root.right);
    }

    private void encodeHelper(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append("n,");
            return;
        }
        sb.append(node.val).append(',');
        encodeHelper(sb, node.left);
        encodeHelper(sb, node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return decodeHelper(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private TreeNode decodeHelper(Queue<String> queue) {
        String v = queue.poll();
        if (v.charAt(0) == 'n') return null;
        TreeNode node = new TreeNode(Integer.parseInt(v));
        node.left = decodeHelper(queue);
        node.right = decodeHelper(queue);
        return node;
    }

}

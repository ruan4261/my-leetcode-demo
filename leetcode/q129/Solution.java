package demo.leetcode.q129;

public class Solution {

    public int sumNumbers(TreeNode root) {
        return helper(0, root);
    }

    private int helper(int number, TreeNode node) {
        if (node == null) return 0;
        number = number * 10 + node.val;
        if (node.left == null && node.right == null) return number;

        return helper(number, node.left) + helper(number, node.right);
    }

}

package demo.leetcode.q144;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    /**
     * morris
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        TreeNode pioneer;
        while (root != null) {
            pioneer = root.left;
            if (pioneer != null) {
                while (pioneer.right != null && pioneer.right != root) pioneer = pioneer.right;

                if (pioneer.right == null) {
                    ans.add(root.val);
                    pioneer.right = root;
                    root = root.left;
                    continue;
                } else pioneer.right = null;
            } else ans.add(root.val);

            root = root.right;
        }

        return ans;
    }

}

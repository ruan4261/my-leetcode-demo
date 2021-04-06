package demo.leetcode.q109;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        init(head);
        return helper(0, len - 1);
    }

    List<Integer> arr = new ArrayList<>();
    int len = 0;

    private void init(ListNode head) {
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        len = arr.size();
    }

    private TreeNode helper(int head, int tail) {
        if (head > tail) return null;

        int mid = (head + tail) >> 1;
        TreeNode root = new TreeNode(arr.get(mid));

        if (head == tail) return root;

        root.left = helper(head, mid - 1);
        root.right = helper(mid + 1, tail);
        return root;
    }
}

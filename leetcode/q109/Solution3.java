package demo.leetcode.q109;

public class Solution3 {

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
        int len = count(head);
        this.head = head;
        return helper(0, len - 1);
    }

    private ListNode head;

    /**
     * 用中序遍历的方式插入值
     *
     * @param head
     * @param tail
     * @return
     */
    private TreeNode helper(int head, int tail) {
        if (head > tail) return null;

        int mid = (head + tail) >> 1;

        TreeNode left = this.helper(head, mid - 1);

        // 当前返回的节点
        TreeNode root = new TreeNode(this.head.val);
        root.left = left;

        this.head = this.head.next;

        root.right = this.helper(mid + 1, tail);
        return root;
    }

    private int count(ListNode head) {
        ListNode temp = head;
        int c = 0;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        return c;
    }
}

package demo.leetcode.q876;

public class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            fast = fast.next;
            if (fast == null) return slow;
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}

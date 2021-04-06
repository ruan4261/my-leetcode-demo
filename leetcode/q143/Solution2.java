package demo.leetcode.q143;

public class Solution2 {

    public void reorderList(ListNode head) {
        ListNode nextHead = nextHead(head);
        ListNode list1 = head;
        ListNode list2 = reverse(nextHead);

        while (list1 != null && list2 != null) {
            ListNode reserve1 = list1.next;
            ListNode reserve2 = list2.next;

            list1.next = list2;
            list2.next = reserve1;

            list1 = reserve1;
            list2 = reserve2;
        }
    }

    /**
     * 从中间节点切断，返回后一段的head
     */
    public ListNode nextHead(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            fast = fast.next;
            if (fast == null) break;
            slow = slow.next;
            fast = fast.next;
        }

        ListNode nextHead = slow.next;
        slow.next = null;
        return nextHead;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

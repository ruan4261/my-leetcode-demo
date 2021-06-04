package demo.leetcode.q160;

public class Solution2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        assert headA != null;
        assert headB != null;

        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }

}

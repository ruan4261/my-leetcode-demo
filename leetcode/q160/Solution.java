package demo.leetcode.q160;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        assert headA != null;
        assert headB != null;
        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            lenB++;
            curr = curr.next;
        }

        if (lenB > lenA) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }

        int gap = Math.abs(lenA - lenB);
        for (int i = 0; i < gap; i++) {
            headA = headA.next;
        }
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

}

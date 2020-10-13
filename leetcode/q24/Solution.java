package demo.leetcode.q24;

public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode nextRoundNode = head.next.next;
        ListNode roundHead = head.next;
        roundHead.next = head;
        head.next = swapPairs(nextRoundNode);

        return roundHead;
    }

}

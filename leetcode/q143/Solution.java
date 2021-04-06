package demo.leetcode.q143;

import java.util.Stack;

public class Solution {

    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        if (stack.size() < 3) return;

        for (; ; ) {
            ListNode insert = stack.pop();
            if (head == insert) {
                head.next = null;
                return;
            }
            if (head.next == insert) {
                insert.next = null;
                return;
            }

            insert.next = head.next;
            head.next = insert;
            head = insert.next;
        }
    }
}

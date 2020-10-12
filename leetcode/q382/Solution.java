package demo.leetcode.q382;

import java.util.Random;

class Solution {

    private final Random random;
    private final ListNode head;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = head;
        int ans = 0, count = 0;

        while (node != null) {
            if (random.nextInt(++count) == 0)
                ans = node.val;

            node = node.next;
        }

        return ans;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
package com.ruan.alg.leetcode.leetcode.q25;

public class Solution2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        // 最终头指针
        ListNode resHead = head;
        // 下一组开头
        ListNode nextHead = head;
        // head参数作为当前头，可供更改
        // 上一组已排序的尾部，等待指针修正
        ListNode lastGroupPointer = null;

        int isCheckHead = 0;
        while (true) {
            // 以备修正
            ListNode noSortHead = nextHead;
            for (int i = 0; i < k; ++i) {
                if (nextHead == null) {
                    // 是否需要修正上一轮指针
                    if (lastGroupPointer != null) {
                        lastGroupPointer.next = noSortHead;
                    }
                    return resHead;
                }
                nextHead = nextHead.next;
            }

            ListNode groupHead = swapPointer(head, nextHead);

            // 是否需要修正上一轮指针
            if (lastGroupPointer != null) {
                lastGroupPointer.next = groupHead;
            }
            lastGroupPointer = head;
            head = nextHead;

            if (isCheckHead == 0) {
                resHead = groupHead;
            }
            isCheckHead++;
        }
    }

    /**
     * 递归进行指针掉头
     *
     * @param curr 当前节点
     * @param stop 停止符
     * @return 段头
     */
    ListNode swapPointer(ListNode curr, ListNode stop) {
        // 如果next节点为最后一个节点，将其标识为段头，指针开始掉头
        if (curr.next.next == stop) {
            curr.next.next = curr;
            return curr.next;
        }
        ListNode res = swapPointer(curr.next, stop);
        curr.next.next = curr;
        return res;
    }
}

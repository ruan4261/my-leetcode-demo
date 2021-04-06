package demo.leetcode.q25;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode reverseKGroup(ListNode head, int k) {
        // 指针不变的...堡垒机(x)www
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 标记还未排序的头
        ListNode pre = dummy;
        // 尾部指针
        ListNode end = dummy;

        while (end.next != null) {// 判断有无下一组
            for (int i = 0; i < k && end != null; i++) {//将尾部指针置位
                end = end.next;
            }
            if (end == null) {//最后一组长度不满足k，可以直接返回结果了
                break;
            }
            ListNode start = pre.next;// 排序前的头，排序后的尾
            ListNode test = end.next;// 用于标记下一组头
            end.next = null;// 截断组尾部的指针
            pre.next = reverse(start);// pre.next为刚刚排好序的组的头，start已经为尾部了
            start.next = test;// 尾部指向了下一组
            pre = start;// pre此时也指向已经排好序的尾部
            end = pre;// 把尾部又赋给end
        }
        // 永远滴神
        return dummy.next;
    }

    /**
     * 从前往后遍历
     * 每次将curr的next指针指向pre，pre用于存放前一次while迭代时的curr
     * 当curr指向空，则当前pre为最尾部，此时指针全部反向，尾部则变为头部，return
     *
     * @param start
     * @return
     */
    ListNode reverse(ListNode start) {
        // 保存上一次的curr
        ListNode pre = null;
        // 当前要修改next属性指针的对象
        ListNode curr = start;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
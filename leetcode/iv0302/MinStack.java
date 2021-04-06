package demo.leetcode.iv0302;

public class MinStack {

    static class Node {
        int val;
        int min;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node top;

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if (top == null) {
            top = new Node(x);
            top.min = x;
        } else {
            Node curr = new Node(x);
            curr.min = Math.min(x, top.min);
            curr.next = top;
            top = curr;
        }
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }

}

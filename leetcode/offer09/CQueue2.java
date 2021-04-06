package demo.leetcode.offer09;

/**
 * 给大伙儿再整个活儿
 */
public class CQueue2 {

    private int[] arr;

    private int head;

    private int tail;

    public CQueue2() {
        arr = new int[10000];
        head = 0;
        tail = 0;
    }

    public void appendTail(int value) {
        arr[head++] = value;
    }

    public int deleteHead() {
        if (head == tail) return -1;
        return arr[tail++];
    }

}

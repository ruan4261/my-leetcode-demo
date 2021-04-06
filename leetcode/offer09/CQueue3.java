package demo.leetcode.offer09;

import java.util.Stack;

/**
 * 这个正常了
 * 我看了老半天才看懂这题目，这两个栈是不重叠的，抽象一下就像俩杯子倒腾热水
 */
public class CQueue3 {

    private Stack<Integer> in, out;

    public CQueue3() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()) return out.pop();
        if (in.isEmpty()) return -1;
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.pop();
    }

}

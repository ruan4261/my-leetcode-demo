package demo.leetcode.q155;

import java.util.Stack;

/**
 * 面白い
 */
public class MinStack3 {

    private int min = Integer.MAX_VALUE;

    private Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

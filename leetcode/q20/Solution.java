package demo.leetcode.q20;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        final int len = s.length();
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int type = helper(ch);
            if (type == 0) continue;
            if (type > 0) {
                stack.push(type);
            } else {
                if (stack.isEmpty()) return false;
                int top = stack.pop();
                if (top + type != 0) return false;
            }
        }

        return stack.isEmpty();
    }

    private int helper(char c) {
        switch (c) {
            case '(':
                return 1;
            case '[':
                return 2;
            case '{':
                return 3;
            case ')':
                return -1;
            case ']':
                return -2;
            case '}':
                return -3;
            default:
                return 0;
        }
    }
}

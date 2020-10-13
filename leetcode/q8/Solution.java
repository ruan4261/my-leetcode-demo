package demo.leetcode.q8;

public class Solution {

    public int myAtoi(String s) {
        final int sit = (Integer.MAX_VALUE - 9) / 10;
        final int len = s.length();
        int ans = 0, idx = 0;
        boolean isPos = true;

        // 确认符号
        for (; idx < len; ) {
            char c = s.charAt(idx);
            if (c == ' ') {
                idx++;
                continue;
            }
            if (c == '+') {
                idx++;
                break;
            }
            if (c == '-') {
                isPos = false;
                idx++;
                break;
            }
            if (c >= '0' && c <= '9') break;
            return ans;
        }

        // 数值计算
        for (; idx < len; ++idx) {
            int n = s.charAt(idx) - '0';
            if (n < 0 || n > 9) return isPos ? ans : -ans;

            if (ans >= sit) {
                if (ans >= sit + 2) return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                if (Integer.MAX_VALUE - ans * 10 <= (isPos ? n : n - 1))
                    return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + n;
        }

        return isPos ? ans : -ans;
    }

}
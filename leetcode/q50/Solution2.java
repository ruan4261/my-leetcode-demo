package demo.leetcode.q50;

/**
 * 妙蛙种子吃着妙脆角进了妙妙屋
 *
 * @author ruan4261
 */
public class Solution2 {

    public double myPow(double x, int n) {
        double ans = 1.0;
        boolean flag = n < 0;
        if (flag) n = -n;

        while (n != 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n = n >>> 1;
        }

        return flag ? 1 / ans : ans;
    }

}
